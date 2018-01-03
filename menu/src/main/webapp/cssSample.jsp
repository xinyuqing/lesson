<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-cmn-Hans">
<head>
    <meta charset="utf-8" />
    <title>css 小栗子</title>
    <meta name="author" content="Joy Du(飘零雾雨), dooyoe@gmail.com, www.doyoe.com" />
    <style>
        body{font:14px/1.5 georgia,simsun,arial;}
        h1{margin:10px 0;font-size:20px;}
        ul{margin:0;padding:0;list-style:none;}
        .table{display:table;border-collapse:collapse;border:1px solid #ccc;}
        .table-caption{display:table-caption;margin:0;padding:0;font-size:16px;}
        .table-column-group{display:table-column-group;}
        .table-column{display:table-column;width:100px;}
        .table-row-group{display:table-row-group;}
        .table-row{display:table-row;}
        .table-row-group .table-row:hover,.table-footer-group .table-row:hover{background:#f6f6f6;}
        .table-cell{display:table-cell;padding:0 5px;border:1px solid #ccc;}
        .table-header-group{display:table-header-group;background:#eee;font-weight:bold;}
        .table-footer-group{display:table-footer-group;}
    </style>
</head>
<body>
<h1>栗子 栗子 这是栗子</h1>
<div class="table">
    <h2 class="table-caption">花名册：</h2>
    <div class="table-column-group">
        <div class="table-column"></div>
        <div class="table-column"></div>
        <div class="table-column"></div>
    </div>
    <div class="table-header-group">
        <ul class="table-row">
            <li class="table-cell">序号</li>
            <li class="table-cell">姓名</li>
            <li class="table-cell">年龄</li>
        </ul>
    </div>
    <div class="table-footer-group">
        <ul class="table-row">
            <li class="table-cell">footer</li>
            <li class="table-cell">footer</li>
            <li class="table-cell">footer</li>
        </ul>
    </div>
    <div class="table-row-group">
        <ul class="table-row">
            <li class="table-cell">1</li>
            <li class="table-cell">John</li>
            <li class="table-cell">19</li>
        </ul>
        <ul class="table-row">
            <li class="table-cell">2</li>
            <li class="table-cell">Mark</li>
            <li class="table-cell">21</li>
        </ul>
        <ul class="table-row">
            <li class="table-cell">3</li>
            <li class="table-cell">Kate</li>
            <li class="table-cell">26</li>
        </ul>
    </div>
</div>
</body>
</html>
