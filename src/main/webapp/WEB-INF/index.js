/**
 * 全局的参数定义
 */
$.extend($.fn.dataTable.defaults, {
    "searching": false,
    "ordering": true
});

$(document).ready(function() {
    $("#hostTable").DataTable({
        "paging": true, //是否开启分页
        "searching": false, //是否开启搜索,
        "deferRender": true, // Ajax的延迟渲染
        "info": true,
        //国际化的支持
        "language": {
            url: "/resource/plugins/datatables/media/i18n/Chinese.json"
        },
        //进行列的定义,包括显示,排序等
        "columnDefs": [{
            "targets": [1],
            "visible": true,
            "searchable": false,
            //row代表每一行,是一个数组类型,内部的值是innerHTML
            "render": function(data, type, row) {
                return data + "( " + row[1] + ")";
            },
            //列创建的回调
            "createdCell": function(td, cellData, rowData, row, col) {

            },
            //默认排序
            "orderSequence": ["asc"]

        }, {
            "targets": [-1],
            "orderable": false, //操作列不进行排序操作
            "searchable": false //不按照此列进行搜索
        }],

        //初始化排序
        "order": [
            [0, "desc"]
        ],

        //DOM位置,过滤框等
        "dom": '<"top"i>rt<"bottom"fp><"clear">',

        //分页组件的显示方式
        "pagingType": "full_numbers",

        //分页长度菜单
        "lengthMenu": [
            [5, 10, 15, -1],
            [5, 10, 15, "All"]
        ],

        //行创建的回调函数,只会调用一次
        "createdRow": function(row, data, index) {

        }



    });

    //事件定义
    $("#hostTable tbody").on("click", "tr", function() {
        var name = $("td", this).eq(0).text();
        alert(name);
    });
});