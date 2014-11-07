/**
 * 全局的参数定义
 */
$.extend($.fn.dataTable.defaults, {
    "searching": false,
    "ordering": true,
    "language": {
        url: "/resource/plugins/datatables/media/i18n/Chinese.json"
    },
    "dom": '<"top"i>rt<"bottom"fp><"clear">',
    "pagingType": "full_numbers",
    "lengthMenu": [
        [5, 10, 15, -1],
        [5, 10, 15, "All"]
    ]
});

/**
 * jQuery主体构建代码
 * @return None
 */
$(document).ready(function() {
    $("#hostTable").DataTable({
        "paging": true, //是否开启分页
        "searching": false, //是否开启搜索,
        "deferRender": true, // Ajax的延迟渲染
        "ajax":"/hoststate",
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
        }, {
            "targets": [-1],
            "orderable": false, //操作列不进行排序操作
            "searchable": false //不按照此列进行搜索
        }],

        columns:[{
            "data":"name"
        },{
            "data":"state"
        },{
            "data":"cpu"
        },{
            "data":"ioWait"
        },{
            "data":"load15"
        },{
            "data":"label"
        }],


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