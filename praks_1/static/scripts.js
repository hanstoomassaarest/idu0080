/**
 * Created by Reimo on 21.02.2017.
 */
function loadInfo() {
    // $.ajax({
    //     dataType: 'jsonp',
    //     url: "http://127.0.0.1:5000/programs/",
    //     crossDomain: true,
    //     success: function() { alert("Success"); },
    //     error: function() { alert('Failed!'); }
    // });
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
        contentType: 'application/json; charset=utf-8',
        success: function(resultData) {
            $.each(resultData, function(i, item) {
                console.log(resultData[i]);
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
                console.log('katki');
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
            console.log(resultData)
            $.each(resultData, function(i, item) {
                console.log(resultData[i]);
                $('#name').val(resultData[i].name);
                $('#designer').val(resultData[i].designer);
                $('#year').val(resultData[i].year);

            });
            },
            error : function(jqXHR, textStatus, errorThrown) {
                console.log('katki');
            },

        timeout: 120000
    });
}