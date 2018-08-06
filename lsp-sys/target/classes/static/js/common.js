/**
 * Created by songbo on 2018/8/6.
 */
(function ($) {
    $.extend({
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
        }
    });
})(jQuery);
