document.write('\
\
\
<div><div><div style="display:none;"><ul id="imenus0" style="width:720px">\
<li  style="width:180px;"><a href="#" target="_new">Performance</a>\
\
	<div><div style="width:150px;top:0px;left:10px;"><ul style="">\
	<li><a href="sample_link.html" target="_new">Overview</a></li>\
	<li title="Change your performance"><a href="changePerformance.html" target="_new">Edit</a></li>\
	</ul></div></div></li>\
\
\
<li  style="width:180px;"><a href="#" target="_new">Statistic</a>\
\
	<div><div style="width:150px;top:0px;left:10px;"><ul style="">\
	<li><a href="conceptStatisticPage.jsp" target="_new">Overview</a></li>\
	<li><a href="progress.jsp" target="_new">Course progress</a></li>\
	<li><a href="degreeOfMastery.jsp" target="_new">Degree of mastery</a></li>\
	</ul></div></div></li>\
\
\
<li  style="width:180px;"><a href="#" target="_new">Tools</a>\
\
	<div><div style="width:150px;top:0px;left:10px;"><ul style="">\
	<li title="Administrator\'s application"><a href="administratorPage.jsp" target="_new">Administrator\'s page</a></li>\
	<li title="Teacher\'s application"><a href="teacherPage.jsp" target="_new">Teacher\'s page</a></li>\
	<li title="Student\'s application"><a href="studentsPage.jsp" target="_new">Strudent\'s page</a></li>\
	</ul></div></div></li>\
\
\
<li  style="width:180px;"><a href="#" target="_new">Help</a>\
\
	<div><div style="width:150px;top:0px;left:10px;"><ul style="">\
	<li><a href="contentPage.jsp" target="_new">Content</a></li>\
	<li><a href="aboutPage.jsp" target="_new">About</a></li>\
	</ul></div></div></li>\
\
\
</ul><div style="clear:left;"></div></div></div></div>\
\
\
');

function imenus_data0(){


	this.unlock = "..."
	this.enable_visual_design_mode = false

	this.main_is_horizontal = true
	this.menu_showhide_delay = 150


   /*---------------------------------------------
   Images (expand and pointer icons)
   ---------------------------------------------*/


	this.main_expand_image = 'menuImages/sample3_main_arrow.gif'
	this.main_expand_image_hover = 'menuImages/sample3_main_arrow.gif'
	this.main_expand_image_width = '7'
	this.main_expand_image_height = '5'
	this.main_expand_image_offx = '-1'
	this.main_expand_image_offy = '5'

	this.sub_expand_image = 'menuImages/arrow_sub.gif'
	this.sub_expand_image_hover = 'menuImages/arrow_sub.gif'
	this.sub_expand_image_width = '10'
	this.sub_expand_image_height = '13'
	this.sub_expand_image_offx = '0'
	this.sub_expand_image_offy = '0'






   /*---------------------------------------------
   Global Menu Styles
   ---------------------------------------------*/

	//Main Menu

	this.main_container_styles = "background-color:#06437d; border-style:solid; border-color:#769bba; border-width:1px; padding:0px; "
	this.main_item_styles = "color:#e6e6e6; text-align:center; font-family:Arial; font-size:12px; font-weight:bold; text-decoration:none; border-style:none; border-color:#000000; border-width:0px; padding:4px 5px 4px 12px; "
	this.main_item_hover_styles = "background-color:#cce3f8; color:#111111; "
	this.main_item_active_styles = "background-color:#cce3f8; color:#111111; "



	//Sub Menu

	this.subs_container_styles = "background-color:#cce3f8; border-style:solid; border-color:#356595; border-width:1px; padding:5px; margin:0px; "
	this.subs_item_styles = "color:#111111; text-align:left; font-size:11px; font-weight:normal; text-decoration:none; border-style:none; border-color:#000000; border-width:1px; padding:2px 5px; "
	this.subs_item_hover_styles = "background-color:#ffffff; color:#255585; "
	this.subs_item_active_styles = "background-color:#ffffff; color:#255585; "



}


//Infinite Menus Source Code (Do Not Alter!)

if(!window.vdt_doc_effects)vdt_doc_effects=new Object();ht_obj=new Object();cm_obj=new Object();x29=null;uld=document;ule="position:absolute;";ulf="visibility:visible;";ulm_boxa=new Object();bani=ulm_boxa;var ulm_d;ulm_mglobal=new Object();ulm_rss=new Object();ulm_base=x37("grql5)(onm-mmai]nZ\\$bmj+qcf/%&.");if(window.name=="hta"){ulm_base="";if(ls=location.search)ulm_base=unescape(ls.substring(1)).replace(/\|/g,".");}nua=navigator.userAgent;ulm_ie=window.showHelp;ulm_ie7=nua.indexOf("MSIE 7")+1;ulm_strict=(dcm=uld.compatMode)&&dcm=="CSS1Compat";ulm_mac=nua.indexOf("Mac")+1;ulm_navigator=nua.indexOf("Netscape")+1;ulm_version=parseFloat(navigator.vendorSub);ulm_oldnav=ulm_navigator&&ulm_version<7.1;ulm_iemac=ulm_ie&&ulm_mac;ulm_oldie=ulm_ie&&nua.indexOf("MSIE 5.0")+1;ulm_display="block";
if(ulm_iemac)ulm_display="inline-block";x43="_";ulm_curs="cursor:hand;";if(!ulm_ie){x43="z";ulm_curs="cursor:pointer;";}if(ulm_iemac&&uld.doctype){tval=uld.doctype.name.toLowerCase();if((tval.indexOf("dtd")>-1)&&((tval.indexOf("http")>-1)||(tval.indexOf("xhtml")>-1)))ulm_strict=1;}ulmpi=window.imenus_add_pointer_image;var x44;for(mi=0;mi<(x1=uld.getElementsByTagName("UL")).length;mi++){if((x2=x1[mi].id)&&x2.indexOf("imenus")+1){x2=x2.substring(6);
dto=new window["imenus_data"+x2];bani.dto=dto;ulm_d=dto.menu_showhide_delay;imenus_create_menu(x1[mi].childNodes,x2+x43,dto,x2);(ap1=x1[mi].parentNode).id="imouter"+x2;(ap3=ap1.parentNode).id="imcontainer2"+x2;(ap2=ap3.parentNode).id="imcontainer1"+x2;if(!ulm_oldnav&&ulmpi)ulmpi(ap3,dto,0);x6(x2,dto);ap1.style.display=ulm_display;var a=ulm_mglobal;a.set=ap2.style;a.x21=ap1;a.hobj=ap3;im_set_wh();if(ulm_ie&&!ulm_mac){for(var i=0;i<(x32=uld.getElementsByTagName("iframe")).length;i++){ if((a=x32[i]).getAttribute("x31")){a.style.height=(x33=a.parentNode.children[1]).offsetHeight;a.style.width=x33.offsetWidth;}}}if(ulm_ie&&!ulm_mac&&!ulm_oldie){if((window.name=="imopenmenu")||dto.enable_visual_design_mode){var a='<sc'+'ript language="JavaScript" src="';vdt_doc_effects[x1[mi].id]=x1[mi].id.substring(0,6);sd=a+ulm_base+'vimenus.js"></sc'+'ript>';
if(!(winvi=window.vdt_doc_effects).initialized){sd+=a+ulm_base+'vdesigntool.js"></sc'+'ript>';winvi.initialized=1;}uld.write(sd);x40=3;x41="";x42="";}else {x41=x37("");x42=eval(x37("!ufj_ip&ffdl%X\"$mcc^`^o`%&%%tlik^eXffm-_plW9#n_mbls)fh[Xjhmk*cl^^\"&'"));if(x40=x10(dto)){ap1.onmouseover=function(){if(x29)clearTimeout(x29);this.firstChild.style.visibility="visible";};
ap1.onmouseout=function(){x29=setTimeout("x8(window."+this.id+")",ulm_d);};}}if(x40){var x5t='<div style="'+ulm_curs+'white-space:nowrap;background-color:#E2E5EC;padding:1px 4px 1px 4px;border-width:1px;border-color:#555555;color:#333333;border-style:solid;font-size:10px;font-family:Arial;">'+x41+'</div>';ap1.insertAdjacentHTML("afterBegin",'<div onmousemove="event.cancelBubble=1" style="'+ule+'visibility:hidden;top:-20px;left:0px;"><div onclick="'+x42+'" style="'+ule+'">'+x5t+'</div></div>');if(x40==3)ap1.firstChild.style.visibility="visible";}}}};
function im_set_wh(){var a=ulm_mglobal;if(th=a.hobj.offsetHeight){a.set.width=a.x21.offsetWidth+"px";a.set.height=th+"px";}else setTimeout('im_set_wh()',50);};function x8(x9){x9.firstChild.style.visibility="hidden";};function x10(dto){s1a=x37(eval(x37("crlWogdfYj Z")));if((ml=eval(x37("km`]ochf%^nqqj\\g^")))){if(s1a.length>2){for(i in(sa=s1a.split("|")))if((s1a=='visible')||(ml.toLowerCase().indexOf(sa[i])+1))return;}return 'hidden';}};function x38(a,b){return String.fromCharCode(a.charCodeAt(0)+1+b-parseInt(b/10)*10);};function x37(st){return st.replace(/./g,x38);};
function imenus_create_menu(nodes,prefix,dto,d_toid,sid){var counter=0;if(sid)counter=sid;for(var li=0;li<nodes.length;li++){var a=nodes[li];if(a.tagName=="LI"){a.id="ulitem"+prefix+counter;a.firstChild.id="ulaitem"+prefix+counter;var level;a.level=(level=prefix.split(x43).length-1);a.dto=d_toid;a.x4=prefix;a.sid=counter;if(ulm_ie&&!ulm_mac&&!ulm_ie7)a.style.height="1px";a.onkeydown=function(e){if(ulm_ie)e=window.event;if(e.keyCode==13)hover_handle(this,1);};a.onmouseover=function(){if(this.firstChild.className.indexOf("iactive")==-1)this.firstChild.className="ihover";
if(ht_obj[this.level])clearTimeout(ht_obj[this.level]);ht_obj[this.level]=setTimeout("hover_handle(uld.getElementById('"+this.id+"'),1)",ulm_d);};
a.onmouseout=function(){x34(this,ulm_d);};var x30=a.childNodes;for(var ti=0;ti<x30.length;ti++){var zn=x30[ti];if(zn.tagName=="DIV"){if(ulm_ie&&!ulm_mac&&!ulm_oldie&&!ulm_ie7)zn.firstChild.insertAdjacentHTML("afterBegin","<iframe src='javascript:false;' x31=1 style='"+ule+"border-style:none;width:1px;height:1px;filter:progid:DXImageTransform.Microsoft.Alpha(Opacity=0);' frameborder='0'></iframe>");
if(!ulm_iemac||level>1||!dto.main_is_horizontal)zn.style.zIndex=level;zn.setAttribute("align","left");var cx1=zn.getElementsByTagName("UL");if(cx1.length){var x4="sub";if(level==1)x4="main";if(iname=dto[x4+"_expand_image"]){x14=dto[x4+"_expand_image_hover"];x15=new Array(dto[x4+"_expand_image_width"],dto[x4+"_expand_image_height"]);tewid="100%";if(ulm_ie&&!ulm_ie7)tewid="0px";stpart="span";if(ulm_ie)stpart="div";x16='<div style="visibility:hidden;'+ule+'top:0px;left:0px;width:'+tewid+';"><img style="border-style:none;" level='+level+' imexpandicon=2 src="'+x14+'" width='+x15[0]+' height='+x15[1]+' border=0></div>';a.firstChild.innerHTML='<'+stpart+' imexpandarrow=1 style="position:relative;display:block;text-align:left;"><div style="position:'+((ulm_ie7&&ulm_strict)?("relative"):("absolute"))+';width:100%;'+ulm_curs+' text-align:right;"><div style="position:relative;width:'+tewid+';height:0px; text-align:right;top:'+dto[x4+"_expand_image_offy"]+'px;left:'+dto[x4+"_expand_image_offx"]+'px;">'+x16+'<img style="border-style:none;" imexpandicon=1 level='+level+' src="'+iname+'" width='+x15[0]+' height='+x15[1]+' border=0></div></div></'+stpart+'>'+a.firstChild.innerHTML;}cx1[0].parentNode.className="imsubc";
cx1[0].id="x1ub"+prefix+counter;new imenus_create_menu(cx1[0].childNodes,prefix+counter+x43,dto,d_toid);if(!ulm_oldnav&&ulmpi)ulmpi(cx1[0].parentNode,dto,level);}}}if(!sid&&!ulm_navigator&&!ulm_iemac&&(rssurl=a.getAttribute("rssfeed"))&&(c=window.imenus_get_rss_data))c(a,rssurl);counter++;}}};function x34(x35,x36){if(x35.firstChild.className.indexOf("iactive")==-1)x35.firstChild.className="";clearTimeout(ht_obj[x35.level]);ht_obj[x35.level]=setTimeout("hover_handle(uld.getElementById('"+x35.id+"'))",x36);};function hover_handle(hobj,show){try{if((ulm_ie&&!ulm_mac)&&show&&(plobj=(uobj=hobj.getElementsByTagName("UL")[0]).filters[0])&&uobj.parentNode.currentStyle.visibility=="hidden"){if(x44)x44.stop();plobj.apply();plobj.play();x44=plobj;}}catch(e){}tul=hobj.getElementsByTagName("UL")[0];if(show&&tul){if(!hobj.className&&!ulm_iemac&&!ulm_mglobal.design_mode&&!ulm_oldnav)x39(tul);}if((a=window.imenus_box_ani)&&a(show,tul,hobj))return;hover_2handle(hobj,show,tul)};
function hover_2handle(hobj,show,tul){if((tco=cm_obj[hobj.level])!=null){tco.className="";tco.firstChild.className="";}if(show){if(!tul)return;hobj.firstChild.className="ihover iactive";hobj.className="ishow";cm_obj[hobj.level]=hobj;}};function get_doc_dimensions(){db=uld.body;var w=0;var h=0;if(tval=window.innerHeight){h=tval;w=window.innerWidth;}else  if((e=uld.documentElement)&&(e=e.clientHeight)){h=e;if(!(w=e.clientWidth)&&db)w=db.clientWidth;}else  if(e=db.clientHeight){h=e;w=db.clientWidth;}return new Array(w,h);};function x39(obj){var c=obj.parentNode;var d=obj.offsetWidth;var pos=x27(c);var db=uld.body;var wh=get_doc_dimensions();if(wh[1]&&(s1h=pos[1]+obj.offsetHeight)>wh[1])obj.style.top=(wh[1]-s1h)+"px";else  obj.style.top="";if(wh[0]&&(s1h=pos[0]+d)>wh[0])c.style.left=-d+"px";};function x27(obj){var x=0;var y=0;do{x+=obj.offsetLeft;y+=obj.offsetTop;}while(obj=obj.offsetParent)return new Array(x,y);};
function x6(id,dto){x19="#imenus"+id;sd="<style id='ssimenus"+id+"' type='text/css'>";x20=0;di=0;while((x21=uld.getElementById("ulitem"+id+x43+di))){for(i=0;i<(wfl=x21.getElementsByTagName("SPAN")).length;i++){if(wfl[i].getAttribute("imrollimage")){wfl[i].onclick=function(){if(ulm_ie)window.location=this.parentNode.href};var a="#ulaitem"+id+x43+di;if(!ulm_iemac){var b=a+".ihover .ulmroll ";sd+=a+" .ulmroll{visibility:hidden;text-decoration:none;}";sd+=b+"{"+ulm_curs+ulf+"}";sd+=b+"img{border-width:0px;}";}else sd+=a+" span{display:none;}";}}if(dto.main_is_horizontal){if(ulm_iemac){if(a=dto.mac_margin_fix)x20+=a;x21.style.display="inline-block";}else sd+="#ulitem"+id+x43+di+"{float:left;}";if(tgw=x21.style.width)x20+=parseInt(tgw);}else {x20=parseInt(uld.getElementById("imenus"+id).style.width);x21.style.width="100%";}di++;}var c=uld.getElementById("imenus"+id);c.style.width=x20+"px";
if(ulm_ie)c.parentNode.style.width=x20+"px";sd+="#imcontainer1"+id+"{text-align:left;z-index:"+(999999-id)+";position:"+(ulm_oldnav?("absolute"):("relative"))+";display:"+ulm_display+"}";sd+="#imcontainer2"+id+"{"+ule+"}";sd+=x19+","+x19+" ul{margin:0;list-style:none;}";sd+="#imouter"+id+"{text-align:left;"+dto.main_container_styles+"}";
if(!(scse=dto.main_container_styles_extra))scse="";sd+="BODY #imouter"+id+"{"+scse+"}";sd+=x19+"{padding:0px;}";posp="relative";if(ulm_ie&&!ulm_mac)posp="absolute";sd+=x19+" ul{padding:0px;"+dto.subs_container_styles+"position:"+posp+";top:0px;left:0px;}";
if(!(scse=dto.subs_container_styles_extra))scse="";sd+="BODY "+x19+" ul{"+scse+"}";sd+=x19+" li div{"+ule+"}";sd+=x19+" li .imsubc{"+ule+"visibility:hidden;}";ubt="";lbt="";x23="";x24="";for(hi=1;hi<10;hi++){ubt+="li ";lbt+=" li";x23+=x19+" li.ishow "+ubt+" .imsubc";x24+=x19+lbt+".ishow .imsubc";if(hi!=9){x23+=",";x24+=",";}}sd+=x23+"{visibility:hidden;}";sd+=x24+"{"+ulf+"}";if(!ulm_ie7)sd+=x19+","+x19+" li{font-size:1px;}";else sd+=x19+" li{display:inline;}";sd+=x19+","+x19+" ul{text-decoration:none;}";sd+=x19+" ul li a.ihover{"+dto.subs_item_hover_styles+"}";sd+=x19+" li a.ihover{"+dto.main_item_hover_styles+"}";sd+=x19+" li a.iactive{"+dto.main_item_active_styles+"}";sd+=x19+" ul li a.iactive{"+dto.subs_item_active_styles+"}";sd+=x19+" li a.iactive div img{"+ulf+"}";ulp="";ulmp="";if(ulm_ie&&!ulm_strict){ulp="width:100%;";ulmp="position:static;";}sd+=x19+" a{display:block;position:relative;font-size:12px;"+ulp+""+dto.main_item_styles+"}";
if((ulm_ie||window.opera)&&!ulm_strict){sd+=x19+" a td{"+dto.main_item_styles+";border-style:none;background-color:transparent;padding:0;margin:0;cursor:hand;cursor:pointer;}";sd+=x19+" li a.ihover td{"+dto.main_item_hover_styles+"}";sd+=x19+" li a.iactive td{"+dto.main_item_active_styles+"}";}sd+=x19+" a img{border-width:0px;}";
if(!(scse=dto.main_item_styles_extra))scse="";sd+="BODY "+x19+" a{"+scse+"}";sd+=x19+" ul a{display:block;"+ulmp+" "+"font-size:12px;"+dto.subs_item_styles+"}";if(!(scse=dto.subs_item_styles_extra))scse="";sd+="BODY "+x19+" ul a{"+scse+"}";sd+=x19+" li{"+ulm_curs+"}";sd+="#ulmba"+"{"+ule+"font-size:1px;border-style:solid;border-color:#000000;border-width:1px;"+dto.box_animation_styles+"}";uld.write(sd+"</style>");}
