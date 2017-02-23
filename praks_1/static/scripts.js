/**
 * Created by Reimo on 21.02.2017.
 */

(function ($) {
    $.fn.serializeFormJSON = function () {

        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };
})(jQuery);

function loadInfo() {
    $( "#tbl-body" ).empty();
   ajaxQueryGetAll('http://127.0.0.1:5000/programs/');

}

function selectById(id){
    ajaxQueryGetById('http://127.0.0.1:5000/programs/' + id);
}

function ajaxQueryGetAll(url){
    var res = "";
    jQuery.ajax({
        url: url,
        type: "GET",
        crossDomain: true,
        dataType: 'json',
        contentType: 'application/json;charset=utf-8',
        success: function(resultData) {
            $.each(resultData, function(i, item) {
              //  console.log(resultData[i]);
                $( "#tbl-body" ).append(
                    '<tr onclick = selectById(' + resultData[i].id + ')>' +
                        '<td>' + resultData[i].id + '</td>' +
                        '<td>' + resultData[i].name + '</td>' +
                        '<td>' + resultData[i].designer + '</td>' +
                        '<td>' + resultData[i].year + '</td>'
                    + '</tr>'
                );
            });
            },
            error : function(jqXHR, textStatus, errorThrown) {
                console.log('error');
            },

        timeout: 120000
    });
}

function ajaxQueryGetById(url){
    var res = "";
    jQuery.ajax({
        url: url,
        type: "GET",
        crossDomain: true,
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        success: function(resultData) {
            //console.log(resultData)
            $.each(resultData, function(i, item) {
              //  console.log("item " + item);
                $('#id').val(resultData[i].id);
                $('#name').val(resultData[i].name);
                $('#designer').val(resultData[i].designer);
                $('#year').val(resultData[i].year);

            });
            },
            error : function(jqXHR, textStatus, errorThrown) {
                console.log('error');
            },

        timeout: 120000
    });
}

function saveProgram(program, code) {
    jQuery.ajax({
        url: 'http://127.0.0.1:5000/programs/' + code + '/update',
        headers: {"X-Requested-With": "XMLHttpPost"},
        type: 'POST',
        crossDomain: true,
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify($(program).serializeFormJSON()),
        complete: function() {
            console.log("update success");
        },
        error : function() {
            console.log('error');
        }
    });
}

function addProgram(program) {
    jQuery.ajax({
        url: 'http://127.0.0.1:5000/programs/insert',
        headers: {"X-Requested-With": "XMLHttpPost"},
        type: 'POST',
        crossDomain: true,
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify($(program).serializeFormJSON()),
        complete: function() {
            console.log("update success");
        },
        error : function() {
            console.log('error');
        }
    });
}