<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <meta charset = "utf-8">
      <meta http-equiv = "X-UA-Compatible" content = "IE = edge">
      <meta name = "viewport" content = "width = device-width, initial-scale = 1">
      
      <title>NightOwl</title>
      
      <!-- Bootstrap -->
      <link href = "//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel = "stylesheet">
      
      <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
      <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
      
      <!--[if lt IE 9]>
      <script src = "https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src = "https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->
      
    <link rel="stylesheet" href="//fonts.googleapis.com/icon?family=Material+Icons">
	<link href='http://fonts.googleapis.com/css?family=Roboto:400,300,300italic,500,400italic,700,700italic' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="//storage.googleapis.com/code.getmdl.io/1.0.1/material.teal-red.min.css" />
	<script src="//storage.googleapis.com/code.getmdl.io/1.0.1/material.min.js"></script>
	<style type="text/css">

	.content-grid {
  		
  		background: #589349
		}
	</style>
      
   </head>
<body>

	<div class="mdl-layout mdl-js-layout">
		<header class="mdl-layout__header">
		
			<div class="mdl-layout__header-row">
     				<span class="mdl-layout-title">Acme</span>
     				<div class="mdl-layout-spacer"></div>
     				<nav class="mdl-navigation">
        <a class="mdl-navigation__link" href="#">Home</a>
        <a class="mdl-navigation__link" href="#">Blog</a>
        <a class="mdl-navigation__link" href="#">About</a>
        <a class="mdl-navigation__link" href="#">Contact</a>
      </nav>
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
   		 
   		 <div class="mdl-layout__drawer">
    <span class="mdl-layout-title">Acme</span>
    <nav class="mdl-navigation">
      <a class="mdl-navigation__link" href="#">Products</a>
      <a class="mdl-navigation__link" href="#">Services</a>
      <a class="mdl-navigation__link" href="#">Portfolios</a>
      <a class="mdl-navigation__link" href="#">Achievements</a>
      <a class="mdl-navigation__link" href="#">Blog</a>
    </nav>
    
  </div>
	<button class="mdl-button mdl-button--raised">Submit</button>
<button class="mdl-button mdl-button--raised mdl-button--colored">Submit</button>
<button class="mdl-button mdl-button--raised mdl-button--accent">Submit</button>
<button class="mdl-button"><i class="material-icons">mode_edit</i></button>
<button class="mdl-button mdl-button--fab mdl-button--colored"><i class="material-icons">mode_edit</i></button>
<button class="mdl-button mdl-button--icon">
    <i class="material-icons">backup</i>
</button>
<button class="mdl-button mdl-js-button mdl-js-ripple-effect">Save</button>
<form action="#">
  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
    <input class="mdl-textfield__input" type="text" id="username"/>
    <label class="mdl-textfield__label" for="username">Username</label>
  </div>
</form>
	</div>
	
	
</body>
</html>