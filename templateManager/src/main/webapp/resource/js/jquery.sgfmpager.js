/*
* jQuery pager plugin
*/
(function($) {

    $.fn.sgfmpager = function(options) {
        var opts = $.extend({}, $.fn.sgfmpager.defaults, options);

        return this.each(function() {

        // empty out the destination element and then render out the pager with the supplied options
            //$(this).empty().append(renderpager(parseInt(options.pagenumber), parseInt(options.pagecount), options.buttonClickCallback));
			$(this).empty();
            renderpager.call(this,parseInt(options.pagenumber), parseInt(options.pagecount),parseInt(options.totalRow), options.buttonClickCallback);
            // specify correct cursor activity
            //$('.pages li').mouseover(function() { document.body.style.cursor = "pointer"; }).mouseout(function() { document.body.style.cursor = "auto"; });
        });
    };

    // render and return the pager with the supplied options
    function renderpager(pagenumber, pagecount,totalRow, buttonClickCallback) {

        // setup $pager to hold render
        var $pager = $(this);

        // add in the previous and next buttons
        $pager.append(renderButton('first', pagenumber, pagecount,totalRow, buttonClickCallback)).append(renderButton('prev', pagenumber, pagecount,totalRow, buttonClickCallback));

        // pager currently only handles 10 viewable pages ( could be easily parameterized, maybe in next version ) so handle edge cases
        var startPoint = 1;
        var endPoint = 5;

        if (pagenumber > 4) {
            startPoint = pagenumber - 2;
            endPoint = pagenumber + 2;
        }

        if (endPoint > pagecount) {
            startPoint = pagecount - 4;
            endPoint = pagecount;
        }

        if (startPoint < 1) {
            startPoint = 1;
        }

        // loop thru visible pages and render buttons
        for (var page = startPoint; page <= endPoint; page++) {

            var currentButton = $('<a class="page-number">' + (page) + '</a>');

            page == pagenumber ? currentButton.addClass('pgCurrent') : currentButton.click(function() { buttonClickCallback(this.firstChild.data); });
            currentButton.appendTo($pager);
        }

        // render in the next and last buttons before returning the whole rendered control back.
        $pager.append(renderButton('next', pagenumber, pagecount,totalRow, buttonClickCallback)).append(renderButton('last', pagenumber, pagecount,totalRow, buttonClickCallback));
		currPageNo = pagenumber;
		//goto the defined page
		$pager.append($('<input type="text" id="txt_go" name="txt_go" class="t_input" /> ').val(pagenumber))
			  .append('<input type="button" name="btn_go" id="btn_go" class="bt_acitve" value="GO" />')
			  .find(":button[id=btn_go]")
			  .click(
					function() {
						var goPage = $(this).siblings(":text[id=txt_go]").attr("value");
						var reg = /[^\d]/g;
	
						if (reg.test(goPage)) {
							$(this).siblings(":text[id=txt_go]").attr("value", pagenumber);
							return false;
						} else {
							if (goPage == "") {
								return false;
							}
							if (goPage < 1) {
								goPage = 1;
							}
	
							if (goPage > pagecount) {
								goPage = pagecount;
							}
							buttonClickCallback(goPage);
						}
	
					});
		if(pagecount > 2){
			$pager.append(" 共 "+pagecount +" 页 " + totalRow+" 条记录 " );
		}else{
			$pager.append(" 共 "+ totalRow+" 条记录 ");
		}
		$pager.append('<input type="hidden" id="recordCount" name="recordCount" value='+totalRow+'>');
        return $pager;
    }

    // renders and returns a 'specialized' button, ie 'next', 'previous' etc. rather than a page number button
    function renderButton(buttonLabel, pagenumber, pagecount,totalRow, buttonClickCallback) {
		
		var buttonName = {
			"first":"首页",
			"prev":"上一页",
			"next":"下一页",
			"last":"尾页"
			};

        var $Button = $('<a class="pgNext">' + buttonName[buttonLabel] + '</a>');

        var destPage = 1;

        // work out destination page for required button type
        switch (buttonLabel) {
            case "first":
                destPage = 1;
                break;
            case "prev":
                destPage = pagenumber - 1;
                break;
            case "next":
                destPage = pagenumber + 1;
                break;
            case "last":
                destPage = pagecount;
                break;
        }

        // disable and 'grey' out buttons if not needed.
        if (buttonLabel == "first" || buttonLabel == "prev") {
            pagenumber <= 1 ? $Button.addClass('pgEmpty') : $Button.click(function() { buttonClickCallback(destPage); });
        }
        else {
            pagenumber >= pagecount ? $Button.addClass('pgEmpty') : $Button.click(function() { buttonClickCallback(destPage); });
        }

        return $Button;
    }

    // pager defaults. hardly worth bothering with in this case but used as placeholder for expansion in the next version
    $.fn.sgfmpager.defaults = {
        pagenumber: 1,
        pagecount: 1
    };

})(jQuery);





