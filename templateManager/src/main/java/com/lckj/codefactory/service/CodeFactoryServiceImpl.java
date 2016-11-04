
package com.lckj.codefactory.service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.lckj.base.exception.ProgramException;
import com.lckj.codefactory.model.ColumnVO;
import com.lckj.codefactory.model.GenerateVO;
import com.lckj.codefactory.model.TableVO;
import com.lckj.codefactory.util.CodeFactoryUtil;

/**
 * 
* @ClassName: CodeFactoryServiceImpl 
* @Description: 生成工具数据库操作类 
* @author: WUJING 
* @date :2016-06-10 上午11:14:04 
*
 */
@Service
public class CodeFactoryServiceImpl implements CodeFactoryService {
    
    @Override
    public List<TableVO> readTableList(GenerateVO generateVO) {
        String[] tableNames = generateVO.getGenerateTable().split(";");
        List<TableVO> tableInfos = new ArrayList<TableVO>();
        for (String tableName : tableNames) {
            TableVO tableInfo = getTableInfo(generateVO, tableName);
            compareColumnInfo(generateVO, tableInfo, getPkInfo(generateVO, tableName));
            tableInfos.add(tableInfo);
        }
        return tableInfos;
    }
    
    /**
     * 获取表信息
     * 
     * @param generateVO 生成工具实体类
     * @param tableName 表名称
     * @return 表信息
     */
    private TableVO getTableInfo(GenerateVO generateVO, String tableName) {
        Connection conn = getConnection(generateVO);
        TableVO table = new TableVO();
        ResultSet rsTable = null;
        try {
            DatabaseMetaData databaseMetaData = conn.getMetaData();
            rsTable = databaseMetaData.getTables(null, generateVO.getTableSchem(), tableName, new String[] { "TABLE" });
            while (rsTable.next()) {
                String noPrefixTableName = tableName.replaceFirst(generateVO.getIgnoreTablePrefix(), "");
                table.setName(rsTable.getString("TABLE_NAME"));
                table.setFirstUpperName(CodeFactoryUtil.getBigCamelCase(noPrefixTableName));
                table.setFirstLowerName(CodeFactoryUtil.getSmallCamelCase(noPrefixTableName));
                table.setLowerName(table.getFirstUpperName().toLowerCase());
                table.setFilePath(generateVO.getFilePath());
                table.setPackagePath(CodeFactoryUtil.getPackagePath(generateVO.getFilePath(), generateVO.getModelName(), table.getLowerName()));
                table.setComment(rsTable.getString("REMARKS"));
            }
        } catch (SQLException ex) {
            throw new ProgramException("获取表信息出错", ex.getCause());
        } finally {
            this.closeConnection(conn, rsTable);
        }
        return table;
    }
    
    /**
     * 组装字段信息
     * 
     * @param generateVO 生成工具实体类
     * @param tableName 表名称
     * @param pkName 主键字段名
     */
    private void compareColumnInfo(GenerateVO generateVO, TableVO tableName, String pkName) {
        Connection conn = getConnection(generateVO);
        ResultSet rsColumn = null;
        try {
            DatabaseMetaData databaseMetaData = conn.getMetaData();
            rsColumn = databaseMetaData.getColumns(null, generateVO.getTableSchem(), tableName.getName(), "%");
            List<ColumnVO> allColumn = new ArrayList<ColumnVO>();
            List<ColumnVO> otherColumn = new ArrayList<ColumnVO>();
            ColumnVO column = new ColumnVO();
            while (rsColumn.next()) {
                column = this.getColumnInfo(rsColumn, pkName);
                if (column.getIsPk()) {
                    tableName.setPkColumn(column);
                } else {
                    otherColumn.add(column);
                }
                allColumn.add(column);
            }
            tableName.setAllColumn(allColumn);
            tableName.setOtherColumn(otherColumn);
            rsColumn.close();
        } catch (SQLException ex) {
            throw new ProgramException("获字段信息出错", ex.getCause());
        } finally {
            this.closeConnection(conn, rsColumn);
        }
    }
    
    /**
     * 获取主键信息
     * 
     * @param generateVO 生成工具实体类
     * @param tableName 表名称
     * @return 主键字段名
     */
    private String getPkInfo(GenerateVO generateVO, String tableName) {
        Connection conn = getConnection(generateVO);
        ResultSet rsPk = null;
        String columnName = "";
        try {
            DatabaseMetaData databaseMetaData = conn.getMetaData();
            rsPk = databaseMetaData.getPrimaryKeys(null, generateVO.getTableSchem(), tableName);
            while (rsPk.next()) {
                columnName = rsPk.getString("COLUMN_NAME");
            }
            rsPk.close();
        } catch (SQLException ex) {
            throw new ProgramException("获主键信息出错", ex.getCause());
        } finally {
            this.closeConnection(conn, rsPk);
        }
        return columnName;
    }
    
    /**
     * 获取字段信息
     * 
     * @param rs 数据库操作结果集合
     * @param pkColum 主键字段
     * @return 字段详情
     */
    private ColumnVO getColumnInfo(ResultSet rs, String pkColum) {
        ColumnVO columnVO = new ColumnVO();
        try {
            String columnName = rs.getString("COLUMN_NAME");
            columnVO.setName(columnName);
            columnVO.setJavaName(CodeFactoryUtil.getSmallCamelCase(columnName));
            columnVO.setFirstUpperName(CodeFactoryUtil.getBigCamelCase(columnName));
            String typeName = rs.getString("TYPE_NAME");
            columnVO.setType(typeName);
            columnVO.setJavaType(CodeFactoryUtil.getJavaTypeByDBType(typeName));
            columnVO.setJdbcType(CodeFactoryUtil.getJdbcTypeByDBType(typeName));
            columnVO.setSize(rs.getInt("COLUMN_SIZE"));
            columnVO.setComment(rs.getString("REMARKS"));
            columnVO.setIsPk(pkColum.equals(columnName));
        } catch (SQLException ex) {
            throw new ProgramException("组装表字段信息出错", ex.getCause());
        }
        return columnVO;
    }
    
    @Override
    public List<String> listTableNames(GenerateVO generateVO) {
        List<String> tableNames = new ArrayList<String>();
        Connection conn = getConnection(generateVO);
        ResultSet rs = null;
        try {
            DatabaseMetaData dbMetaData = conn.getMetaData();
            String[] types = { "TABLE" };
            rs = dbMetaData.getTables(null, "".equals(generateVO.getTableSchem()) ? null : generateVO.getTableSchem(), "%"
                + generateVO.getTablePrefix().toUpperCase() + "%", types);
            while (rs.next()) {
                tableNames.add(rs.getString("TABLE_NAME"));
            }
        } catch (SQLException e) {
            throw new ProgramException("查询表名的时候出错", e.getCause());
        } finally {
            this.closeConnection(conn, rs);
        }
        return tableNames;
    }
    
    // public List<String> listSchems(GenerateVO generateVO) {
    // CodeFactoryServiceImpl.generateVO = generateVO;
    // List<String> schems = new ArrayList<String>();
    // Connection conn = getConnection();
    // ResultSet rs = null;
    // try {
    // DatabaseMetaData dbMetaData = conn.getMetaData();
    // rs = dbMetaData.getSchemas();
    // while (rs.next()) {
    // schems.add(rs.getString("TABLE_SCHEM"));
    // }
    // } catch (SQLException e) {
    // throw new ProgramException("查询SCHEM的时候出错", e.getCause());
    // } finally {
    // this.closeConnection(conn, rs);
    // }
    // return schems;
    // }
    
    /**
     * 获取数据库连接信息
     * 
     * @param generateVO 生成工具实体类
     * @return 数据库连接信息
     */
    private Connection getConnection(GenerateVO generateVO) {
        Connection connection = null;
        try {
            Class.forName(generateVO.getDriver());
            Properties props = new Properties();
            props.put("user", generateVO.getUserName());
            props.put("password", generateVO.getPassword());
            props.put("remarksReporting", "true");
            props.setProperty("remarks", "true"); // 设置可以获取remarks信息
            props.setProperty("useInformationSchema", "true");// 设置可以获取tables remarks信息
            connection = DriverManager.getConnection(generateVO.getUrl(), props);
        } catch (ClassNotFoundException e) {
            throw new ProgramException("找不到驱动类", e.getCause());
        } catch (SQLException e) {
            throw new ProgramException("连接不到数据库", e.getCause());
        }
        return connection;
    }
    
    /**
     * 获取数据库连接信息
     * 
     * @param generateVO 生成工具实体类
     * @return 数据库连接信息
     */
    public static Connection getTestConnection() {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Properties props = new Properties();
            props.put("user", "pvm_new");
            props.put("password", "pvm_1234");
            props.put("remarksReporting", "true");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.125:1521:ORCL", props);
        } catch (ClassNotFoundException e) {
            throw new ProgramException("找不到驱动类", e.getCause());
        } catch (SQLException e) {
            throw new ProgramException("连接不到数据库", e.getCause());
        }
        return connection;
    }
    
    // public static void main(String[] args) {
    // System.out.println(CodeFactoryServiceImpl.getTestConnection());
    // }
    
    /**
     * 关闭数据库连接信息
     * 
     * @param conn 数据库连接
     * @param rs 操作结果集
     */
    private void closeConnection(Connection conn, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
