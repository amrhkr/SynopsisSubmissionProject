
var btnGetProject=document.getElementsByClassName("getProjectDetails")
var btnGetStudent=document.getElementById("getStudent")
var btnGetEvaluator=document.getElementById("getEvaluator")
var btnAddStudent=document.getElementById("addStudent")
var btnAddEvaluator=document.getElementById("addEvaluator")

if(btnGetStudent){
	btnGetStudent.addEventListener("click",showStudents);
	}
if(btnGetEvaluator){
	btnGetEvaluator.addEventListener("click",showEvaluators);
	}

if(btnGetProject){
	
	}
	
for(var i=0;i<btnGetProject.length;i++){
	btnGetProject[i].addEventListener("click",showProject);
	
}

function showProject(event){
	console.log(event);
	var url='showProject';
	console.log(event.path[2].cells[0].innerText);
	url=url+"?studentProjectId="+event.path[2].cells[0].innerText;
	console.log(url);
	$.ajax({
		type: "GET",
		url: url,
		contentType:"html",
        crossDomain: true,
        success: function (data) {
            $('#content1').html(data);
            
        },
        error: function () {
            alert("no project data");
            console.log("error in showProject() ajax");
        }
	});
}

function showStudents()
{
    $.ajax({
        type: "GET",
        url: 'showStudents',
        contentType:"html",
        crossDomain: true,
        success: function (data) {
            $('#content').html(data);
            
        },
        error: function () {
            alert("no student data");
            console.log("error in showStudents() ajax");
        }
       });
}
function showEvaluators()
{
    $.ajax({
        type: "GET",
        url: 'showEvaluators',
        contentType:"html",
        crossDomain: true,
        success: function (data) {
            $('#content').html(data);
            
        },
        error: function () {
            alert("no evaluator data");
            console.log("error in showEvaluators() ajax");
        }
       });
}
