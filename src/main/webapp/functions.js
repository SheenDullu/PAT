
//document.getElementById("UploadFile").style.visibility = 'hidden';

/*var app = angular.module('myApp', []);

app.controller('myController',function($scope,$http){

    $scope.uploadFile = function() {
        console.log("Hiiiiiii")
        $http.get("read.do").then(function (response) {
            console.log(response)
        });
    }
});
app.controller('myController', function ($scope, $http) {

    $scope.uploadFile = function () {
        document.getElementById("UploadFile").style.visibility = 'visible';

        var fd = new FormData();
        fd.append("file",document.getElementById("file"));
        $http.post("/read.do", fd).success(function (result, status, header, config) {
            if(result.equals("success"){
                alert("Uploaded Successfully");
            }else
            {
                alert("Failed. Try again.");
            }
        });
    }
});*/

function uploadFile() {
    var formData = new FormData(document.forms[0]);
    var xmlHTTP = new XMLHttpRequest();

    $.ajax({
        type: "post",
        url:"/read.do",
        data:formData,
        processData: false,
        contentType: false,
        success: function(response){
            alert("yoo "+response);
        },
        error: function(response){
            alert("error "+response);
        }

    })

}
function getReportees() {
    var id = parseInt($("#managerID").val());
    $.ajax({
        type: "get",
        url:"/getReportees.do?id="+id,
        dataType:"text",
        success: function(response){
            records = eval(response);
            showTable(records);
        },
        error: function(response){
            alert("Hello error "+response);
        }

    })
}

function showTable(result) {
    var htmlText = "<table id='myTable'>" +
        "<tr><th><h2>ID</h2></th>" +
        "<th><h2>First Name</h2></th>" +
        "<th><h2>Last Name</h2></th>" +
        "<th><h2></h2></th>" +
        "</tr>";
    $.each(result,function (index,reportie) {
        htmlText += "<tr id ="+ reportie.id+" ><td>" + reportie.id +
            "</td><td>" + reportie.firstName +
            "</td><td>" + reportie.lastName +
            "</td><td>" + "<button onclick='viewAppraisal("+reportie.id+")'>View Appraisal</button>" +
            "</td></tr>";
    });

    htmlText +="</table>";
    $("#viewAssociate").html(htmlText);

}