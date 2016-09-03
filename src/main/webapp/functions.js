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
    var formData = new FormData();
    var files = $("#fileupload").get(0).files;
    formData.append("file", files[0]);
    $.ajax({
        type: "post",
        url: "/read.do",
        data: formData,
        processData: false,
        contentType: false,
        success: function (response) {
            alert("yoo " + response);
        },
        error: function (response) {
            alert("error " + response);
        }

    });

}
function getReportees() {
    var id = parseInt($("#managerID").val());
    $.ajax({
        type: "get",
        url: "/getReportees.do?id=" + id,
        dataType: "text",
        success: function (response) {
            records = JSON.parse(response);
            showTable(records);
        },
        error: function (response) {
            alert("Hello error " + response);
        }

    })
}

function showTable(result) {
    var htmlText = "<div class='panel-group' id='accordion'>";
    htmlText += "<div class='panel-heading'>" +
        "<h2 class='panel-title' onclick='graphs(0)'>" +
        "<a data-toggle='collapse' data-parent='#accordion'  href='#"+result.AssociateDTO[0].id+"'>" + result.AssociateDTO[0].firstName + "   " + result.AssociateDTO[0].lastName + "</a>" +
        "</h2>" +
        "</div>" +
        "<div id='" + result.AssociateDTO[0].id + "' class='panel-collapse collapse in'>" +
        "<div class='panel-body' id ='hello0'>" + "</div>" +
        "</div>" +
        "</div>";
    for (index = 1; index < result.AssociateDTO.length; index++) {
        htmlText += "<div class='panel-heading'  >" +
            "<h2 class='panel-title' onclick='graphs("+index+")'>" +
            "<a data-toggle='collapse' data-parent='#accordion' href='#" +result.AssociateDTO[index].id+ "'>" + result.AssociateDTO[index].firstName + "   " + result.AssociateDTO[index].lastName + "</a>" +
            "</h2>" +
            "</div>" +
            "<div id='" + result.AssociateDTO[index].id + "' class='panel-collapse collapse'>" +
            "<div class='panel-body' id='hello"+index+"'>" + "</div>" +
            "</div>" +
            "</div>";
    }

    htmlText += "</div>";
    $("#viewAssociate").html(htmlText);
}
function graphs(i) {
    var htmlText = "<div><img src='recent-images-11.jpg' alt='image'/></div>";
    $("#hello"+i).html(htmlText);
}


function viewAppraisal(id) {
    $.ajax({
        type: "get",
        url: "/getAppraisal.do?id=" + id,
        dataType: "text",
        success: function (response) {
            showDivision(response);
        },
        error: function (response) {
            alert("Hello error " + response);
        }

    })

}
function showDivision(response) {
    var htmlText = ""
}