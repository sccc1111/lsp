/**
 * Created by songbo on 2018/8/6.
 */
(function ($) {
    $.extend({
        // 弹出层封装处理
        modal: {
            // 显示图标
            icon: function(type) {
                var icon = "";
                if (type == modal_status.WARNING) {
                    icon = 0;
                } else if (type == modal_status.SUCCESS) {
                    icon = 1;
                } else if (type == modal_status.FAIL) {
                    icon = 2;
                } else {
                    icon = 3;
                }
                return icon;
            },
            // 消息提示
            msg: function(content, type) {
                if (type != undefined) {
                    layer.msg(content, { icon: $.modal.icon(type), time: 1000, shift: 5 });
                } else {
                    layer.msg(content);
                }
            },
            // 错误消息
            msgError: function(content) {
                $.modal.msg(content, modal_status.FAIL);
            },
            // 成功消息
            msgSuccess: function(content) {
                $.modal.msg(content, modal_status.SUCCESS);
            },
            // 警告消息
            msgWarning: function(content) {
                $.modal.msg(content, modal_status.WARNING);
            },
            // 弹出提示
            alert: function(content, type) {
                if(top.layer)layer = top.layer;
                layer.alert(content, {
                    icon: $.modal.icon(type),
                    title: "系统提示",
                    btn: ['确认'],
                    btnclass: ['btn btn-primary'],
                });
            },
            // 消息提示并刷新父窗体
            msgReload: function(msg, type) {
                if(top.layer)layer = top.layer;
                layer.msg(msg, {
                        icon: $.modal.icon(type),
                        time: 500,
                        shade: [0.1, '#8F8F8F']
                    },
                    function() {
                        $.modal.reload();
                    });
            },
            // 错误提示
            alertError: function(content) {
                $.modal.alert(content, modal_status.FAIL);
            },
            // 成功提示
            alertSuccess: function(content) {
                $.modal.alert(content, modal_status.SUCCESS);
            },
            // 警告提示
            alertWarning: function(content) {
                $.modal.alert(content, modal_status.WARNING);
            },
            // 关闭窗体
            close: function () {
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            },
            // 确认窗体
            confirm: function (content, callBack) {
                layer.confirm(content, {
                    icon: 3,
                    title: "系统提示",
                    btn: ['确认', '取消'],
                    btnclass: ['btn btn-primary', 'btn btn-danger'],
                }, function (index) {
                    layer.close(index);
                    callBack(true);
                });
            },
            // 弹出层指定宽度
            open: function (title, url, width, height) {
                //如果是移动端，就使用自适应大小弹窗
                if (navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) {
                    width = 'auto';
                    height = 'auto';
                }
                if ($.common.isEmpty(title)) {
                    title = false;
                };
                if ($.common.isEmpty(url)) {
                    url = "404.html";
                };
                if ($.common.isEmpty(width)) {
                    width = 800;
                };
                if ($.common.isEmpty(height)) {
                    height = ($(window).height() - 50);
                };
                layer.open({
                    type: 2,
                    area: [width + 'px', height + 'px'],
                    fix: false,
                    //不固定
                    maxmin: true,
                    shade: 0.3,
                    title: title,
                    content: url
                });
            },
            // 弹出层全屏
            openFull: function (title, url, width, height) {
                //如果是移动端，就使用自适应大小弹窗
                if (navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) {
                    width = 'auto';
                    height = 'auto';
                }
                if ($.common.isEmpty(title)) {
                    title = false;
                };
                if ($.common.isEmpty(url)) {
                    url = "404.html";
                };
                if ($.common.isEmpty(width)) {
                    width = 800;
                };
                if ($.common.isEmpty(height)) {
                    height = ($(window).height() - 50);
                };
                var index = layer.open({
                    type: 2,
                    area: [width + 'px', height + 'px'],
                    fix: false,
                    //不固定
                    maxmin: true,
                    shade: 0.3,
                    title: title,
                    content: url
                });
                layer.full(index);
            },
            // 打开遮罩层
            loading: function (message) {
                $.blockUI({ message: '<div class="loaderbox"><div class="loading-activity"></div> ' + message + '</div>' });
            },
            // 关闭遮罩层
            closeLoading: function () {
                setTimeout(function(){
                    $.unblockUI();
                }, 50);
            },
            // 重新加载
            reload: function () {
                parent.location.reload();
            }
        },
        common:{
            // 判断字符串是否为空
            isEmpty: function (value) {
                if (value == null || this.trim(value) == "") {
                    return true;
                }
                return false;
            },
            trim:function (value) {
                if (value == null) {
                    return "";
                }
                return value.toString().replace(/(^\s*)|(\s*$)|\r|\n/g, "");
            }
        },
        doAction :{
            //一般后台访问
            ajax:function(options){
                var defaults = {
                    async:true,
                    url : '',
                    type : 'POST',
                    async: true,
                    contentType : 'application/json;charset=UTF-8',
                    data : {},// 数据 必须是字符串JSON.stringify(loginstr)
                    dataType : 'json',// 期望返回类型 json, xml
                    processData : false,// 防止 data 被预处理
                    success : function(data) {

                    },
                    error:function(req,msg,ex_){

                    },
                    exception:function(ex_){

                    }
                }
                var options_ = $.extend(defaults, options);
                if(options_.url){
                    $.ajax({
                        url: options_.url,
                        type: 'POST',// 必须是POST
                        async: options_.async,
                        contentType:'application/json;charset=UTF-8',
                        data: JSON.stringify(options_.data),// 数据 必须是字符串
                        dataType: options_.dataType,// 期望返回类型 json, xml
                        processData: false,// 防止 data 被预处理
                        success:function(data){//options_.success
                            if(data.exception){
                                layer.alert(data.exception.message, {icon: 2,zIndex: layer.zIndex},function(index_){
                                    layer.close(index_);
                                });
                            }else{
                                if(options_.success)options_.success(data);
                            }
                        }
                    });
                }
            }
        }
    });
})(jQuery);
/** 弹窗状态码 */
modal_status = {
    SUCCESS: "success",
    FAIL: "error",
    WARNING: "warning"
};