/**
 * Created by songbo on 2018/8/9.
 */
(function ($) {
    $.extend({
        formToUrlData: function (jq) {
            var str = jq.map(function () {
                return ($(this).attr("name") + "=" + $(this).val());
            }).get().join("&")
            return str;
        }
    })
    $.fn.extend({
        formToUrlData : function () {
            var str = this.map(function () {
                return ($(this).attr("name") + "=" + $(this).val());
            }).get().join("&")
            return str;
        }
    })
})(jQuery)
