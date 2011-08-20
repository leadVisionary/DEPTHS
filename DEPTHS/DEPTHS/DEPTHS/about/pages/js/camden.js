//©Xara Ltd
var clicked="";
var gtype=".jpg";
var selstate="_over";
var funcCall="";

if (typeof(loc)=="undefined" || loc==""){
	var loc="";
if (document.body&&document.body.innerHTML){
	var tt=document.body.innerHTML;
	var ml=tt.match(/["']([^'"]*)camden.js["']/i);
	if(ml && ml.length > 1) loc=ml[1];}}
	document.write("<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr>");
	tr(false);
	writeButton("","changePerformancePage.jsp","camden_b1",139,24,"Performance","",0,"popupSmallWindow");
	writeButton("","conceptStatisticPage.jsp","camden_b2",139,24,"Statistic","",0,"popupWindow");
	writeButton("","","camden_b3",139,24,"Help","",0);
	writeButton("","aboutPage.jsp","camden_b4",139,24,"About","",0,"popupMiddleWindow");
	tr(true);
	document.write("</tr></table>");
	loc="";
function tr(b){}
function turn_over(name) {
	if (document.images != null && clicked != name) {document[name].src = document[name+"_over"].src;}}

function turn_off(name) {
	if (document.images != null && clicked != name) {document[name].src = document[name+"_off"].src;}}
function reg(gname,name){
	if (document.images){document[name+"_off"] = new Image();
	document[name+"_off"].src = loc+gname+gtype;
	document[name+"_over"] = new Image();
	document[name+"_over"].src = loc+gname+"_over"+gtype;}}
function evs(name){ 
	return " onmouseover=\"turn_over('"+ name + "')\" onmouseout=\"turn_off('"+ name + "')\""}

function writeButton(urld,url,name,w,h,alt,target,hsp,func){
	gname=name;
	while(typeof(document[name])!="undefined")name+="x";
	reg(gname,name);
	tr(true);
	document.write("<td>");
	if(alt!="")alt=" alt=\""+alt+"\"";
	if(target!="")target=" target=\""+target+"\"";
	if(w>0)w=" width=\""+w+"\"";
	else w="";
	if(h>0)h=" height=\""+h+"\"";
	else h="";
	
	if (func=="popupSmallWindow"){funcCall="onclick=\"popupSmallWindow('"+url+"'); return false\""}
	else if (func=="popupWindow"){funcCall="onclick=\"popupWindow('"+url+"'); return false\""}
	else if (func=="popupMiddleWindow"){funcCall="onclick=\"popupMiddleWindow('"+url+"'); return false\""}
	else {funcCall=""}
		
	if(url!="")url=" href=\""+urld+url+"\"";
	if(typeof(clx)!="undefined"){target="";
	url=" href=\"?"+clx+"\"";
	alt=" alt=\"Click to edit\"";}
	document.write("<a "+url+evs(name)+funcCall+target+">");
	if(hsp==-1)hsp=" align=\"right\"";
	else if(hsp>0)hsp=" hspace=\""+hsp+"\"";
	else hsp="";
	document.write("<img src=\""+loc+gname+gtype+"\" name=\""+name+"\""+w+h+alt+hsp+" border=\"0\" /></a></td>");
	tr(false);
	
	}
	
	
	function popupWindow(url) {
		var left = (screen.width - 1000)/2;
		left = left<0?0:left;
		var top  = (screen.height - 980)/2;
		top = top<0?0:top;
		window640 = window.open(url,"window640"
								,"location=0,scrollbars=1,menubar=0,toolbar=0,status=1,resizable=1,directories=0,left="+left+",top="+top+",width=1000,height=880");
		
	}
	function popupSmallWindow(url) {
		var left = (screen.width - 650)/2;
		left = left<0?0:left;
		var top  = (screen.height - 500)/2;
		top = top<0?0:top;
		window640 = window.open(url,"window640"
								,"location=0,scrollbars=1,menubar=0,toolbar=0,status=1,resizable=1,directories=0,left="+left+",top="+top+",width=650,height=450");
		
	}
	function popupMiddleWindow(url) {
		var left = (screen.width - 650)/2;
		left = left<0?0:left;
		var top  = (screen.height - 500)/2;
		top = top<0?0:top;
		window640 = window.open(url,"window640"
								,"location=0,scrollbars=1,menubar=0,toolbar=0,status=1,resizable=1,directories=0,left="+left+",top="+top+",width=650,height=550");
		
	}