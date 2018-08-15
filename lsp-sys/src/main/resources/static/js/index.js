/**
 * Created by songbo on 2018/8/10.
 */
//JavaScript代码区域
layui.use(['element'], function(){
    var element = layui.element;
});
$(function () {
    var tabWidth = $(window).width() - $(".layui-side").outerWidth();
    $(".layui-tab-nav").width(tabWidth);

    //计算元素集合的总宽度
    function calSumWidth(elements) {
        var width = 0;
        $(elements).each(function() {
            width += $(this).outerWidth(true);
        });
        return width;
    }

    function scrollToTab(e){
        var lw = calSumWidth($(e).prevAll());
        var rw = calSumWidth($(e).nextAll());
        var vw = $(".layui-tab-nav").width() -  $(".tab-left-page").outerWidth(true) - $(".tab-right-page").outerWidth(true) - $(".tab-operate-page").outerWidth(true);
        var scroll;
        console.log("总宽："+vw);
        console.log("现宽："+calSumWidth($(".mainTab")));
        console.log("左现宽："+lw);
        console.log("右现宽："+rw);
        if(calSumWidth($(".mainTab")) < vw){
            scroll=0;
        }else if(rw <= (vw  - $(e).outerWidth(true)-$(e).next().outerWidth())){
            if(vw - $(e).next().outerWidth(true)>rw){
                scroll = lw;
                var tabElement = e;
                while ((scroll - $(tabElement).outerWidth()) > ($(".layui-tab-title1").outerWidth() - vw)) {
                    scroll -= $(tabElement).prev().outerWidth();
                    tabElement = $(tabElement).prev();
                }
            }
        }else if (lw > (vw - $(e).outerWidth(true) - $(e).prev().outerWidth(true))) {
            scroll = lw - $(e).prev().outerWidth(true);
        }
        console.log("移动："+scroll);
        $('.layui-tab-title1').animate({left: 0 - scroll});
    }
    //操作面板
    $(".tab-operate-page").on("click",function () {
        $(".layui-nav-operate").addClass("layui-show");
    })
    $(".tab-operate-page").on("blur",function (e) {
        $(".layui-nav-operate").removeClass("layui-show");
    })

    $(".menuItem").on("click",menuItem);
    //菜单跳转事件
    function menuItem() {
        var menuId = $(this).data("menuid"),
        url = $(this).data("href"),
        menuName = $(this).data("menuname");
        //空的场合退出
        if(url == "" || url == null || url == undefined||url=="#") return;

        var flag = false;
        $(".mainTab").each(function () {
            if ($(this).data('menuid') == menuId) {
                flag = true;
                if(!$(this).hasClass("active")){
                    $(this).addClass('active').siblings('.mainTab').removeClass('active');
                }
                scrollToTab($(this));
                $('.layui-tab-content .mainIframe').each(function() {
                    if ($(this).data('menuid') == menuId) {
                        $(this).show().siblings('.mainIframe').hide();
                        return false;
                    }
                });
            }
        })
        //创建TAB
        if(!flag){
            console.log("创建TAB")
            $('.mainTab').removeClass('active');
            var str = '<li class="mainTab active"  data-menuid="'+menuId+'" data-href="'+url+'" data-menuName="'+menuName+'">'+menuName+' <i class="layui-icon layui-unselect layui-tab-close">ဆ</i></li>'
            $(".layui-tab-title1").append(str);
            scrollToTab($('.mainTab.active'));
            var iframe = '<iframe class="mainIframe" src="'+url+'" width="100%" height="100%" frameborder="0" data-menuid="'+menuId+'" data-menuname="'+menuName+'"></iframe>'
            $(".layui-tab-item").find('iframe.mainIframe').hide().parents('.layui-tab-item').append(iframe)
            $.modal.loading("数据加载中，请稍后...");
            $('.layui-tab-content iframe:visible').load(function () {
                $.modal.closeLoading();
            });
        }
    }
    //tab显示
    function tabShow() {
        var menuId = $(this).data("menuid");
        $(".mainTab").each(function () {
            if ($(this).data('menuid') == menuId) {
                if(!$(this).hasClass("active")){
                    $(this).addClass('active').siblings('.mainTab').removeClass('active');
                }
                $('.layui-tab-content .mainIframe').each(function() {
                    if ($(this).data('menuid') == menuId) {
                        $(this).show().siblings('.mainIframe').hide();
                        return false;
                    }
                });
            }
        })
    }
    $(".main-tab").on("click",".mainTab",tabShow);

    //tab关闭
    function tabClose() {
        var menuId = $(this).parent().data("menuid");
        if($(this).parent().hasClass("active")){
            var $pre = $(this).parent().prev()
            $pre.addClass("active");
            $(this).parent().remove();
            $('.layui-tab-content .mainIframe').each(function() {
                if ($(this).data('menuid') == $pre.data('menuid')) {
                    $(this).show().siblings('.mainIframe').remove();
                    return false;
                }
            });
            scrollToTab($pre);
        }else {
            $(this).parent().remove();
            scrollToTab($(".active"));
        }
    }
    $(".main-tab").on("click","i.layui-tab-close",tabClose);

    //关闭当前
    function tabCloseCur() {
        alert(1)
        var $cur = $(".active");
        if($cur.data("menuid")!="9999"){
            var $pre = $cur.prev().addClass("active");
            $cur.remove();
            $('.layui-tab-content .mainIframe').each(function() {
                if ($(this).data('menuid') == $cur.data('menuid')) {
                    $(this).remove();
                }else if ($(this).data('menuid') == $pre.data('menuid')){
                    $(this).show();
                }
            });
            scrollToTab($(".active"));
        }
    }

    $(".tabCloseCur").on("click",tabCloseCur);

    //关闭其他
    function tabCloseOther() {
        $(".mainTab").each(function () {
            if($(this).data("menuid")!="9999" || $(this).data("menuid")!=$(".active").data("menuid")){
                $(this).remove();
            }
        })
        $('.layui-tab-content .mainIframe').each(function() {
            if($(this).data("menuid")!="9999"){
                $(this).remove();
            }
        });
        scrollToTab($(".active"));
    }

    $(".tabCloseOther").on("click",tabCloseOther);

    //全部关闭
    function tabCloseAll() {
        $(".mainTab:first").addClass("active");
        $(".mainTab").each(function () {
            if($(this).data("menuid")!="9999"){
                $(this).remove();
            }
        });
        $('.layui-tab-content .mainIframe').each(function() {
            if($(this).data("menuid")!="9999"){
                $(this).remove();
            }else {
                $(this).show();
            }
        });
        scrollToTab($(".active"));
    }
    $(".tabCloseAll").on("click",tabCloseAll);

})

