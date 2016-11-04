<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.io.*" %>
<%@ page import="java.net.URLEncoder" %>
<%
   String filePath = request.getParameter("filePath");
   String fileName = request.getParameter("fileName");
   response.reset();   
   fileName = URLEncoder.encode(fileName,"UTF-8");   
   response.setHeader("Location",fileName);
   response.setHeader("Content-Disposition", "attachment; filename=" + fileName); 
   File file = null;
   try  {
       file =  new File(filePath);
       if(file.exists()  &&  file.canRead()) {
          OutputStream outp = null;
          FileInputStream in = null;
          try{
              outp = response.getOutputStream();
              in = new FileInputStream(file);    
              byte[] b = new byte[4096];
              int i = 0;
              while((i = in.read(b)) > 0){
                  outp.write(b, 0, i);
              }
              outp.flush();
              out.clear(); 
              out = pageContext.pushBody();               
          }catch(Exception e){
              System.out.println("获取文件异常：filePath==="+filePath);
          }finally{
              if(in != null){
                  in.close();
                  in = null;
              }
              if(outp != null){                 
                  outp.close();
                  outp = null;
              }
          }          
       }
   } catch  (Exception ex) {
       System.out.println("获取文件异常：filePath==="+filePath);
   } finally{
       if (file != null ){
           file = null;
       }
   }  
%>