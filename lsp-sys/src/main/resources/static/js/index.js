/**
 * Created by songbo on 2018/8/10.
 */
//JavaScript代码区域
layui.use(['element'], function(){
    var element = layui.element;
});
$(function () {
    //操作面板
    $(".tab-operate-page").on("click",function () {
        $(this).find(".layui-nav-operate").addClass("layui-show");
    })
    $(".tab-operate-page").on("blur",function () {
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
            $('.mainTab').removeClass('active');
            var str = '<li class="menuItem mainTab active" data-menuid="'+menuId+'" data-href="'+url+'" data-menuName="'+menuName+'">'+menuName+' <i class="layui-icon layui-unselect layui-tab-close">ဆ</i></li>'
            $(".layui-tab-title").append(str);
            $(".layui-tab-close").on("click",tabClose);
            $(".menuItem").on("click",menuItem);
            var iframe = '<iframe class="mainIframe" src="'+url+'" width="100%" height="100%" frameborder="0" data-menuid="'+menuId+'" data-menuname="'+menuName+'"></iframe>'
            $(".layui-tab-item").find('iframe.mainIframe').hide().parents('.layui-tab-item').append(iframe)
            $.modal.loading("数据加载中，请稍后...");
            $('.layui-tab-content iframe:visible').load(function () {
                $.modal.closeLoading();
            });
        }
    }

    //tab关闭
    function tabClose() {
        var menuId = $(this).parent().data("menuid");

    }
})

