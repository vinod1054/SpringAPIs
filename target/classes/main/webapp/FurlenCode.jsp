<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" href="https://code.getmdl.io/1.1.2/material.indigo-pink.min.css">
	<script defer src="https://code.getmdl.io/1.1.2/material.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<title>9tOwl</title>
 <style>
      #map {
        height: 400px;
      }
        body
        {
            font-family: Arial;
            font-size: 10pt;
        }
        
        .ui-front { z-index: 9999; }
        
        ul.ui-autocomplete {
    z-index: 1100;
}
ul.auto-complete-list {
    list-style-type: none;
    margin: 0;
    padding: 0;
    position: absolute;
    z-index: 1500;
    max-height: 250px;
    overflow: auto;
}

	.pac-container{
	z-index: 9999;
	width:500px;
	overflow: visible;
	}
      
    </style>
    
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
</head>
<body>


		<script>
		var commentsArray=new Array();
		$(document).ready(function(){
			$("#search-expandable").keyup(function(event){
			    if(event.keyCode == 13){
			        $("#search-expandable").click();
			    }
			});
    	    $("#search-expandable").click(function(){
    	    	console.log($("#search-expandable").val());
    	    	$("#myTable tr").remove();
    	    	$.get("http://localhost:8080/inviteweb/api/search/",
    	    			
    	    		    {
    	    		        query:$("#search-expandable").val()
    	    		    },
    	    		    function(data, status){
    	    		    	var table = document.getElementById("myTable");
    	    		    	var row = table.insertRow(0);
    	    		    	console.log(data);
    	    		    	var obj = jQuery.parseJSON( data );
    			            var count=0;
    			            $.each(JSON.parse(obj.data), function(idx, obj) {
    			            	if(count==0){
    			            		document.cookie="placeid="+obj.id;
    			            		placeId=obj.id;
    			            		}
    			            	count++;
    			            	title=obj.name;
    			            	console.log(title);
    			            	commentsArray[parseInt(placeId)]=obj.comments;
    			            	console.log(obj.comments);
    			            	console.log(parseInt(placeId));
    			            	var arr=title.split(",");
    			            	for(var i=0;i<arr.length;i++)
    			            		arr[i]=arr[i].trim();
    			            	title=arr.join("-");
    			            	document.cookie="placeid"+obj.id+"="+title;
    			            	$('#myTable tr:last').after('<tr style="width:100%;"><td style="width:100%;"><button onclick=setCookie('+obj.id+','+obj.lat+','+obj.lang+') style="width:100%;" class="mdl-button mdl-button--raised mdl-button--colored mdl-js-ripple-effect mdl-button--accent">'+obj.name+'</button></td></tr>');
    			            });
    	    		    });
    	    });
    	});
		
		</script>

	<div class="mdl-layout mdl-js-layout">
		<header class="mdl-layout__header">
		
			<div class="mdl-layout__header-row">
     				<span class="mdl-layout-title" id="title-head">NightOwl</span>
     				<div class="mdl-layout-spacer"></div>
      <!-- start search form -->
  <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable">
    <label class="mdl-button mdl-js-button mdl-button--icon" for="search-expandable">
      <i class="material-icons">search</i>
    </label>
    <div class="mdl-textfield__expandable-holder">
      <input class="mdl-textfield__input" type="text" id="search-expandable" />
      <label class="mdl-textfield__label" for="search-expandable">Search text</label>
    </div>
  </div>
  <!-- end search form -->
  			  </div>
		
   		 </header>
   		 
	<div class="content-grid mdl-grid" >
	  <div class="mdl-cell mdl-cell--3-col mdl-cell--2-col-tablet mdl-cell--2-col-phone" >
	    <table id="myTable" style="width:100%;">
	    <tr style="width:100%;"><td></td></tr>
	    
	    <script>
	    
	    	var placeId;
	    	var title="NightOwl";
			function getLocation() {
			    if (navigator.geolocation) {
			        navigator.geolocation.getCurrentPosition(showPosition);
			    } else {
			        console.log("Geolocation is not supported by this browser.");
			    }
			}
			function setCookie(x,y,z){
				console.log(x+" argument");
				console.log(placeId+" global "+y+" "+z+" ");
				document.cookie="placeid="+x+"";
				placeId=x;
				showComments(placeId); 
				console.log(placeId+" global chnaged");
				document.getElementById("title-head").innerHTML=getCookie("placeid"+getCookie("placeid"));
				var myLatlng = new google.maps.LatLng(y,z);
				var mapOptions = {
						  zoom: 13,
						  center: myLatlng
						}
						var map = new google.maps.Map(document.getElementById("map"), mapOptions);

						var marker = new google.maps.Marker({
						    position: myLatlng,
						    title:"Hello World!"
						});

						// To add the marker to the map, call setMap();
						marker.setMap(map);
			}
			function showPosition(position) {
			    console.log( "Latitude: " + position.coords.latitude + 
			    "<br>Longitude: " + position.coords.longitude); 
			    $.get("http://localhost:8080/inviteweb/api/getplaces/?lat="+position.coords.latitude+"&lang="+position.coords.longitude, function(data, status){
		            var obj = jQuery.parseJSON( data );
		            var count=0;
		            $.each(JSON.parse(obj.data), function(idx, obj) {
		            	if(count==0){
		            		document.cookie="placeid="+obj.id;
		            		placeId=obj.id;
		            		}
		            	count++;
		            	title=obj.name;
		            	console.log(title);
		            	var arr=title.split(",");
		            	for(var i=0;i<arr.length;i++)
		            		arr[i]=arr[i].trim();
		            	title=arr.join("-");
		            	commentsArray[parseInt(placeId)]=obj.comments;
		            	console.log(obj.comments);
		            	console.log(parseInt(placeId));
		            	document.cookie="placeid"+obj.id+"="+title;
		            	$('#myTable tr:last').after('<tr style="width:100%;"><td style="width:100%;"><button onclick=setCookie('+obj.id+','+obj.lat+','+obj.lang+') style="width:100%;" class="mdl-button mdl-button--raised mdl-button--colored mdl-js-ripple-effect mdl-button--accent">'+obj.name+'</button></td></tr>');
		            });
		        });
			}
			function showComments(x){
				console.log("comments goes here");
				console.log(commentsArray[parseInt(x)]);
				$.each(JSON.parse(commentsArray[parseInt(x)]), function(idx, obj) {
					console.log(comment);
	            	if(comment!=null){
	            		
	            	}
	            });
			}
			getLocation();
	  	</script>
	    </table>
	    
	  </div>
	  <div class="mdl-cell mdl-cell--6-col mdl-cell--4-col-tablet mdl-cell--2-col-phone" >
	    <div id="map"></div>
	    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
		    <button id="submit-button-mark-close" class="submit-button-mark-close mdl-button mdl-button--raised mdl-button--colored">Mark This Place as Closed</button>
		  </div>
		  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
		    <button id="submit-button-mark-open" class="submit-button-mark-open mdl-button mdl-button--raised mdl-button--colored">Mark This Place as Open</button>
		  </div>
		  <div>
		  
		  	<table id="myComments">
		  		<tr><td></td></tr>
		  		
		  	</table>
		  
		  </div>
    <script>
      function initMap() {
        var mapDiv = document.getElementById('map');
        var map = new google.maps.Map(mapDiv, {
          center: {lat: 44.540, lng: -78.546},
          zoom: 8
        });
      }
    </script>
    
	   
	  </div>
	  <div class="mdl-cell mdl-cell--3-col mdl-cell--2-col-tablet mdl-cell--4-col-phone" >
	   
		  
		  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
		    <input class="mdl-textfield__input" type="text" id="authornamec"/>
		    <label class="mdl-textfield__label" for="username">Your Name</label>
		  </div>
		  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
		    <input class="mdl-textfield__input" type="text" id="ratingc"/>
		    <label class="mdl-textfield__label" for="rating">Rating (out of 5)</label>
		  </div>
		  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
		    <input class="mdl-textfield__input" type="text" id="comments"/>
		    <label class="mdl-textfield__label" for="comments">Comments</label>
		  </div>
	    
	    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
		    <button class="submit-button-c mdl-button mdl-button--raised mdl-button--colored">Submit</button>
		  </div>
	    
	  </div>
	</div>


	<!-- Colored FAB button with ripple -->
	<button id="add-button" style="position:fixed;top:85%;right:2%;" class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored">
	  <i class="material-icons">add</i>
	</button>
	
	
	
  <dialog class="mdl-dialog">
    <div class="mdl-dialog__content">
    
      <form action="#">
      	 
		  <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyC7lQt6u9-isdUwwMbWPH9PDuVrooaY4rU&sensor=false&libraries=places&callback=initMap"></script>
    <script type="text/javascript">
    var latitude;
    var longitude;
        google.maps.event.addDomListener(window, 'load', function () {
            var places = new google.maps.places.Autocomplete(document.getElementById('txtPlaces'));
            google.maps.event.addListener(places, 'place_changed', function () {
                var place = places.getPlace();
                var address = place.formatted_address;
                 latitude = place.geometry.location.lat();
                 longitude = place.geometry.location.lng();
                var mesg = "Address: " + address;
                mesg += "\nLatitude: " + latitude;
                mesg += "\nLongitude: " + longitude;
                console.log(mesg);
            });
            $('.ui-autocomplete').css('z-index', 99999999999999);
        	$('.pac-container').css('z-index', 99999999999999);
        	$('.pac-container').css('width', 500);
        	$('.pac-item').css('z-index', 99999999999999);
        	$('.pac-item').css('width', 500);
        });
        $(document).ready(function(){
    	    $(".submit-button").click(function(){
    	    	console.log($("#txtPlaces").val());
    	    	console.log($("#authorname").val());
    	    	console.log($("#rating").val());
    	    	var item = {};
    	    	item["name"]=$("#txtPlaces").val();
    	    	item["author"]=$("#authorName").val();
    	    	item["rating"]=$("#rating").val();
    	    	item["lat"]=latitude+"";
    	    	item["lang"]=longitude+"";
    	    	$.get("http://localhost:8080/inviteweb/api/createplace/",
    	    			
    	    		    {
    	    		        data:JSON.stringify(item)
    	    		    },
    	    		    function(data, status){
    	    		        console.log(data);
    	    		        dialog.close();
    	    		    });
    	    });
    	});
        $(document).ready(function(){
    	    $(".submit-button-mark-close").click(function(){
    	    	console.log("close");
    	    	var item = {};
    	    	$.get("http://localhost:8080/inviteweb/api/openorclose/",
    	    			
    	    		    {
    	    		        placeid:placeId,
    	    		        isopen:false
    	    		    },
    	    		    function(data, status){
    	    		        console.log(data);
    	    		        document.getElementById("submit-button-mark-close").style.display = 'none';
    	    		    });
    	    });
    	});
        $(document).ready(function(){
    	    $(".submit-button-mark-open").click(function(){
    	    	console.log("open");
    	    	var item = {};
    	    	$.get("http://localhost:8080/inviteweb/api/openorclose/",
    	    			
    	    		    {
    	    		        placeid:placeId,
    	    		        isopen:true
    	    		    },
    	    		    function(data, status){
    	    		        console.log(data);
    	    		        document.getElementById("submit-button-mark-open").style.display = 'none';
    	    		    });
    	    });
    	});
        function getCookie(cname) {
            var name = cname + "=";
            var ca = document.cookie.split(';');
            for(var i=0; i<ca.length; i++) {
                var c = ca[i];
                while (c.charAt(0)==' ') c = c.substring(1);
                if (c.indexOf(name) == 0) {
                    return c.substring(name.length, c.length);
                }
            }
            return "";
        }
        	$(document).ready(function(){
        	    $(".submit-button-c").click(function(){
        	    	var x=$("#authornamec").val();
        	    	var y=$("#ratingc").val();
        	    	var z=$("#comments").val();
        	    	console.log(getCookie("placeid") +" plid");
        	    	console.log(placeId+" global d "+x+" "+y+" "+" "+z);
        	    	var item = {};
	    	    	item["author"]=x;
	    	    	item["rating"]=y;
	    	    	item["comment"]=z
	    	    	$.get("http://localhost:8080/inviteweb/api/addcomment/",
	    	    			
	    	    		    {
	    	    				placeid:getCookie("placeid"),
	    	    		        data:JSON.stringify(item)
	    	    		    },
	    	    		    function(data, status){
	    	    		        console.log(data);
	    	    		        alert("Comment Added");
	    	    		    });
	    	    });
        	});
    </script>
 
 	<script>
	
	</script>	  
		  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
		    <input class="mdl-textfield__input" type="text" id="txtPlaces"/>
		    <label class="mdl-textfield__label" for="location">Enter Location</label>
		  </div>
		  
		  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
		    <input class="mdl-textfield__input" type="text" id="authorname"/>
		    <label class="mdl-textfield__label" for="username">Name</label>
		  </div>
		  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
		    <input class="mdl-textfield__input" type="text" id="rating"/>
		    <label class="mdl-textfield__label" for="rating">Rating (out of 5)</label>
		  </div>
		</form>
    </div>
    <div class="mdl-dialog__actions ">
	<button class="mdl-button mdl-button--raised mdl-button--accent close">Close</button>
	<button class="submit-button mdl-button mdl-button--raised mdl-button--colored">Submit</button>
	
    </div>
  </dialog>
  <script>
    var dialog = document.querySelector('dialog');
    var showModalButton = document.querySelector('#add-button');
    if (! dialog.showModal) {
      dialogPolyfill.registerDialog(dialog);
    }
    showModalButton.addEventListener('click', function() {
      dialog.showModal();
    });
    dialog.querySelector('.close').addEventListener('click', function() {
   		
      dialog.close();
    });
  </script>
  
	</div>
	


</body>
</html>