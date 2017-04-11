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

function loadInfo(line) {
    $("#tbl-body").empty();
    ajaxQueryGetAll('http://127.0.0.1:5000/programs/', line);

}

function selectById(id) {
    ajaxQueryGetById('http://127.0.0.1:5000/programs/' + id);
}

function ajaxQueryGetAll(url, line) {
    var res = "";
    jQuery.ajax({
        url: url,
        type: "GET",
        crossDomain: true,
        dataType: 'json',
        contentType: 'application/json;charset=utf-8',
        success: function (resultData) {
            if (line !== '') {
                // $("#body").append(line);
            }
            $.each(resultData, function (i, item) {
                //  console.log(resultData[i]);
                $("#tbl-body").append(
                    '<tr onclick = selectById(' + resultData[i].id + ')>' +
                    '<td>' + resultData[i].id + '</td>' +
                    '<td>' + resultData[i].name + '</td>' +
                    '<td>' + resultData[i].designer + '</td>' +
                    '<td>' + resultData[i].year + '</td>' +
                    '<td><button style="z-index:999" type="submit" class="btn btn-danger" onclick="deleteProgram(' + resultData[i].id + ')"> Delete</button></td>' +
                    '</tr>'
                );
            });
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log('error');
        },

        timeout: 120000
    });
}

function ajaxQueryGetById(url) {
    jQuery.ajax({
        url: url,
        type: "GET",
        crossDomain: true,
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        success: function (resultData) {
            //console.log(resultData)
            $.each(resultData, function (i, item) {
                //  console.log("item " + item);
                $('#id').val(resultData[i].id);
                $('#name').val(resultData[i].name);
                $('#designer').val(resultData[i].designer);
                $('#year').val(resultData[i].year);

            });
        },
        error: function (jqXHR, textStatus, errorThrown) {
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
        success: function (msg) {
            if (msg.status == "success") {
                console.log(msg)
            } else {
                console.log(msg);
            }
        },
        error: function (msg) {
            console.log(msg);
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
        success: function (msg) {
            if (msg.status == "success") {
                console.log('Success');
                return true;
            } else {
                console.log(msg);
            }
        },
        error: function (xhr, ajaxOptions, thrownError) {
            if (xhr.status === 400) {
                console.log(xhr.responseText);
            }
            return false;
        }
    });
}

function deleteProgram(id) {
    jQuery.ajax({
        url: 'http://127.0.0.1:5000/programs/' + id + '/delete',
        headers: {"X-Requested-With": "XMLHttpPost"},
        type: 'POST',
        crossDomain: true,
        // dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: 'id',
        complete: function () {
            loadInfo('Deleted record with id: ' + id);
            console.log("delete success");
        },
        error: function () {
            // console.log('error');
        }
    });
}

function searchPrograms(id, name, designer, year) {
    $("#tbl-body").empty();
    ajaxQueryGetAll('http://127.0.0.1:5000/programs/search/?id=' + id
        + '&name=' + name
        + '&designer=' + designer
        + '&year=' + year, 'Search results');
    // http://127.0.0.1:5000/programs/search/?id=&name=&designer=&year=
}

function addErrorMessage(errorMessageShort) {
    var $addErrorElement = $("#addError"),
        getErrorMessage = function (errorMessage) {
            console.log('Converting ' + errorMessage + ' to proper sentence');
            switch (errorMessage) {
                case 'yearTooSmall':
                    return 'The year number must be over 1900';
                case 'yearTooBig':
                    return 'The year number must be smaller';
                case 'yearNotNumber':
                    return 'Please enter a valid number as year';
                case 'allFieldsMandatory':
                    return 'Name, designer and year fields are mandatory';
                case 'nameIsMandatory':
                    return 'Name is mandatory';
                case 'designerIsMandatory':
                    return 'Designer is mandatory';
                case 'success':
                    return 'All good! Refresh the page';
                default:
                    return 'Something went wrong';
            }
        }

        $addErrorElement.empty();
        $addErrorElement.html(getErrorMessage(errorMessageShort));
}

$(document).ready(function() {
    // Start a STOMP server over Websocket
    var ws = new WebSocket('ws://127.0.0.1:15674/ws');
    var client = Stomp.over(ws);

    var on_connect = function(x) {
      id = client.subscribe("/exchange/errors", function(errorMessage) {
        console.log('Got a response from message from RABBIT- ', errorMessage.body);
        addErrorMessage(errorMessage.body);
      });
    };

    var on_error =  function() {
        addErrorMessage('Error');
    };

/*    $('#sendRabbitMessageTest').on('click', function(){
        var message = JSON.stringify($('#addForm').serializeFormJSON());

        client.send('/exchange/errors', {"content-type":"text/plain"}, message);
    });*/

    client.connect('guest', 'guest', on_connect, on_error, '/');
});