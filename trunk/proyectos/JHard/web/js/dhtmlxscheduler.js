/*
Copyright DHTMLX LTD. http://www.dhtmlx.com
You allowed to use this component or parts of it under GPL terms
To use it on other terms please contact us at sales@dhtmlx.com
*/
dhtmlxAjax={
get:function(A,C){
	var B=new dtmlXMLLoaderObject(true);
	B.async=(arguments.length<3);
	B.waitCall=C;
	B.loadXML(A);
	return B
	}, post:function(A,C,D){
		var B=new dtmlXMLLoaderObject(true);
		B.async=(arguments.length<4);
		B.waitCall=D;B.loadXML(A,true,C);
		return B
		}, getSync:function(A){
			return this.get(A,null,true)
			}, postSync:function(A,B){
				return this.post(A,B,null,true)
				}
};

function dtmlXMLLoaderObject(B,D,C,A){
	this.xmlDoc="";
	if(typeof (C)!="undefined"){
		this.async=C
	}
	else
	{
		this.async=true
	}
	this.onloadAction=B||null;
	this.mainObject=D||null;
	this.waitCall=null;
	this.rSeed=A||false;
	return this
}

dtmlXMLLoaderObject.prototype.waitLoadFunction=function(B){
	var A=true;this.check=function(){
		if((B)&&(B.onloadAction!=null)){
			if((!B.xmlDoc.readyState)||(B.xmlDoc.readyState==4)){
				if(!A){
				return 
				}
				A=false;
				if(typeof B.onloadAction=="function"){
					B.onloadAction(B.mainObject,null,null,null,B)
				}
				if(B.waitCall){
					B.waitCall.call(this,B);
					B.waitCall=null
				}
			}
		}
	};
	return this.check
};

dtmlXMLLoaderObject.prototype.getXMLTopNode=function(C,A){
	if(this.xmlDoc.responseXML){
		var B=this.xmlDoc.responseXML.getElementsByTagName(C);
		if(B.length==0&&C.indexOf(":")!=-1){
			var B=this.xmlDoc.responseXML.getElementsByTagName((C.split(":"))[1])
		}
		var E=B[0]
	}else
	{
		var E=this.xmlDoc.documentElement
	}
	if(E){
		this._retry=false;return E
	}
	if((_isIE)&&(!this._retry)){
		var D=this.xmlDoc.responseText;
		var A=this.xmlDoc;this._retry=true;
		this.xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
		this.xmlDoc.async=false;
		this.xmlDoc.loadXML(D);
		return this.getXMLTopNode(C,A)
	}
	dhtmlxError.throwError("LoadXML","Incorrect XML",[(A||this.xmlDoc),this.mainObject]);
	return document.createElement("DIV")
};
	
dtmlXMLLoaderObject.prototype.loadXMLString=function(B){
	try{
		var C=new DOMParser();
		this.xmlDoc=C.parseFromString(B,"text/xml")
	}catch(A){
		this.xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
		this.xmlDoc.async=this.async;
		this.xmlDoc.loadXML(B)
	}
	this.onloadAction(this.mainObject,null,null,null,this);
	if(this.waitCall){
		this.waitCall();
		this.waitCall=null
	}
};

dtmlXMLLoaderObject.prototype.loadXML=function(C,B,A,D){
	if(this.rSeed){
		C+=((C.indexOf("?")!=-1)?"&":"?")+"a_dhx_rSeed="+(new Date()).valueOf()
	}
	this.filePath=C;
	if((!_isIE)&&(window.XMLHttpRequest)){
		this.xmlDoc=new XMLHttpRequest()
	}
	else{
		if(document.implementation&&document.implementation.createDocument){
			this.xmlDoc=document.implementation.createDocument("","",null);
			this.xmlDoc.onload=new this.waitLoadFunction(this);
			this.xmlDoc.load(C);return 
		}
		else{
			this.xmlDoc=new ActiveXObject("Microsoft.XMLHTTP")
		}
	}
		if(this.async){
			this.xmlDoc.onreadystatechange=new this.waitLoadFunction(this)
		}
		this.xmlDoc.open(B?"POST":"GET",C,this.async);
		if(D){
			this.xmlDoc.setRequestHeader("User-Agent","dhtmlxRPC v0.1 ("+navigator.userAgent+")");
			this.xmlDoc.setRequestHeader("Content-type","text/xml")
		}else{
			if(B){
				this.xmlDoc.setRequestHeader("Content-type","application/x-www-form-urlencoded")
			}
		}
		this.xmlDoc.setRequestHeader("X-Requested-With","XMLHttpRequest");
		this.xmlDoc.send(null||A);
		if(!this.async){
			(new this.waitLoadFunction(this))()
		}
};

dtmlXMLLoaderObject.prototype.destructor=function(){
	this.onloadAction=null;
	this.mainObject=null;
	this.xmlDoc=null;
	return null
};

dtmlXMLLoaderObject.prototype.xmlNodeToJSON=function(D){
	var C={};
	for(var B=0;B<D.attributes.length;B++){
		C[D.attributes[B].name]=D.attributes[B].value}C._tagvalue=D.firstChild?D.firstChild.nodeValue:"";
		for(var B=0;B<D.childNodes.length;B++){
			var A=D.childNodes[B].tagName;
			if(A){
				if(!C[A]){C[A]=[]}C[A].push(this.xmlNodeToJSON(D.childNodes[B]))
			}
		}
		return C
};

function callerFunction(A,B){
	this.handler=function(C){
		if(!C){
			C=window.event
		}
		A(C,B);
		return true
	};
	return this.handler
}

function getAbsoluteLeft(B){
	var C=B.offsetLeft;
	var A=B.offsetParent;
	while(A!=null){
		C+=A.offsetLeft;
		A=A.offsetParent
	}
	return C
}

function getAbsoluteTop(C){
	var B=C.offsetTop;
	var A=C.offsetParent;
	while(A!=null){
		B+=A.offsetTop;
		A=A.offsetParent
	}
	return B
}

function convertStringToBoolean(A){
	if(typeof (A)=="string"){
		A=A.toLowerCase()
	}
	switch(A){
	case"1":
	case"true":
	case"yes":
	case"y":
	case 1:
	case true:
	return true;
	break;
	default:
	return false
	}
}

function getUrlSymbol(A){
	if(A.indexOf("?")!=-1){
		return"&"
	}else{
		return"?"
	}
}

function dhtmlDragAndDropObject(){
	if(window.dhtmlDragAndDrop){
		return window.dhtmlDragAndDrop
	}
	this.lastLanding=0;
	this.dragNode=0;
	this.dragStartNode=0;
	this.dragStartObject=0;
	this.tempDOMU=null;
	this.tempDOMM=null;
	this.waitDrag=0;
	window.dhtmlDragAndDrop=this;
	return this
}

dhtmlDragAndDropObject.prototype.removeDraggableItem=function(A){
	A.onmousedown=null;
	A.dragStarter=null;
	A.dragLanding=null
};

dhtmlDragAndDropObject.prototype.addDraggableItem=function(A,B){
	A.onmousedown=this.preCreateDragCopy;
	A.dragStarter=B;
	this.addDragLanding(A,B)
};

dhtmlDragAndDropObject.prototype.addDragLanding=function(A,B){A.dragLanding=B};

dhtmlDragAndDropObject.prototype.preCreateDragCopy=function(A){
	if(A&&(A||event).button==2){
		return 
	}
	if(window.dhtmlDragAndDrop.waitDrag){
		window.dhtmlDragAndDrop.waitDrag=0;
		document.body.onmouseup=window.dhtmlDragAndDrop.tempDOMU;
		document.body.onmousemove=window.dhtmlDragAndDrop.tempDOMM;
		return false
	}
	window.dhtmlDragAndDrop.waitDrag=1;
	window.dhtmlDragAndDrop.tempDOMU=document.body.onmouseup;
	window.dhtmlDragAndDrop.tempDOMM=document.body.onmousemove;
	window.dhtmlDragAndDrop.dragStartNode=this;
	window.dhtmlDragAndDrop.dragStartObject=this.dragStarter;
	document.body.onmouseup=window.dhtmlDragAndDrop.preCreateDragCopy;
	document.body.onmousemove=window.dhtmlDragAndDrop.callDrag;
	if((A)&&(A.preventDefault)){
		A.preventDefault();
		return false
	}
	return false
};

dhtmlDragAndDropObject.prototype.callDrag=function(C){
	if(!C){
		C=window.event
	}
	dragger=window.dhtmlDragAndDrop;
	if((C.button==0)&&(_isIE)){
		return dragger.stopDrag()
	}
	if(!dragger.dragNode&&dragger.waitDrag){
		dragger.dragNode=dragger.dragStartObject._createDragNode(dragger.dragStartNode,C);
		if(!dragger.dragNode){
			return dragger.stopDrag()
		}
		dragger.dragNode.onselectstart=function(){
			return false
		};
		dragger.gldragNode=dragger.dragNode;
		document.body.appendChild(dragger.dragNode);
		document.body.onmouseup=dragger.stopDrag;
		dragger.waitDrag=0;
		dragger.dragNode.pWindow=window;
		dragger.initFrameRoute()
	}
	if(dragger.dragNode.parentNode!=window.document.body){
		var A=dragger.gldragNode;
		if(dragger.gldragNode.old){
			A=dragger.gldragNode.old
		}
		A.parentNode.removeChild(A);
		var B=dragger.dragNode.pWindow;
		if(_isIE){
			var E=document.createElement("Div");
			E.innerHTML=dragger.dragNode.outerHTML;
			dragger.dragNode=E.childNodes[0]
		}
		else{
			dragger.dragNode=dragger.dragNode.cloneNode(true)
		}
		dragger.dragNode.pWindow=window;
		dragger.gldragNode.old=dragger.dragNode;
		document.body.appendChild(dragger.dragNode);
		B.dhtmlDragAndDrop.dragNode=dragger.dragNode
	}
	dragger.dragNode.style.left=C.clientX+15+(dragger.fx?dragger.fx*(-1):0)+(document.body.scrollLeft||document.documentElement.scrollLeft)+"px";
	//dragger.dragNode.style.top=C.clientY+3+(dragger.fy?dragger.fy*(-1):0)+(document.body.scrollTop||document.documentElement.scrollTop)+"px";
    dragger.dragNode.style.top=C.clientY+3+(dragger.fy?dragger.fy*(-1):0)+"10%"; // guardalo y probalo
	if(!C.srcElement){
		var D=C.target
	}else{
		D=C.srcElement
	}
	dragger.checkLanding(D,C)
};

dhtmlDragAndDropObject.prototype.calculateFramePosition=function(E){
	if(window.name){
		var C=parent.frames[window.name].frameElement.offsetParent;
		var D=0;
		var B=0;
		while(C){
			D+=C.offsetLeft;
			B+=C.offsetTop;
			C=C.offsetParent
		}
		if((parent.dhtmlDragAndDrop)){
			var A=parent.dhtmlDragAndDrop.calculateFramePosition(1);
			D+=A.split("_")[0]*1;B+=A.split("_")[1]*1
		}
		if(E){
			return D+"_"+B
		}else{
			this.fx=D
		}
		this.fy=B
	}
	return"0_0"
};

dhtmlDragAndDropObject.prototype.checkLanding=function(B,A){
	if((B)&&(B.dragLanding)){
		if(this.lastLanding){
			this.lastLanding.dragLanding._dragOut(this.lastLanding)
		}
		this.lastLanding=B;
		this.lastLanding=this.lastLanding.dragLanding._dragIn(this.lastLanding,this.dragStartNode,A.clientX,A.clientY,A);
		this.lastLanding_scr=(_isIE?A.srcElement:A.target)
	}else{
		if((B)&&(B.tagName!="BODY")){
			this.checkLanding(B.parentNode,A)
		}else{
			if(this.lastLanding){
				this.lastLanding.dragLanding._dragOut(this.lastLanding,A.clientX,A.clientY,A)
			}
			this.lastLanding=0;
			if(this._onNotFound){
				this._onNotFound()
			}
		}
	}
};

dhtmlDragAndDropObject.prototype.stopDrag=function(B,C){
	dragger=window.dhtmlDragAndDrop;
	if(!C){
		dragger.stopFrameRoute();
		var A=dragger.lastLanding;
		dragger.lastLanding=null;
		if(A){
			A.dragLanding._drag(dragger.dragStartNode,dragger.dragStartObject,A,(_isIE?event.srcElement:B.target))
		}
	}
	dragger.lastLanding=null;
	if((dragger.dragNode)&&(dragger.dragNode.parentNode==document.body)){
		dragger.dragNode.parentNode.removeChild(dragger.dragNode)
	}
	dragger.dragNode=0;
	dragger.gldragNode=0;
	dragger.fx=0;
	dragger.fy=0;
	dragger.dragStartNode=0;
	dragger.dragStartObject=0;
	document.body.onmouseup=dragger.tempDOMU;
	document.body.onmousemove=dragger.tempDOMM;
	dragger.tempDOMU=null;
	dragger.tempDOMM=null;
	dragger.waitDrag=0
};
		
dhtmlDragAndDropObject.prototype.stopFrameRoute=function(B){
	if(B){
		window.dhtmlDragAndDrop.stopDrag(1,1)
	}
	for(var A=0;A<window.frames.length;A++){
		if((window.frames[A]!=B)&&(window.frames[A].dhtmlDragAndDrop)){
			window.frames[A].dhtmlDragAndDrop.stopFrameRoute(window)
		}
	}
	if((parent.dhtmlDragAndDrop)&&(parent!=window)&&(parent!=B)){
		parent.dhtmlDragAndDrop.stopFrameRoute(window)
	}
};

dhtmlDragAndDropObject.prototype.initFrameRoute=function(B,C){
	if(B){
		window.dhtmlDragAndDrop.preCreateDragCopy();
		window.dhtmlDragAndDrop.dragStartNode=B.dhtmlDragAndDrop.dragStartNode;
		window.dhtmlDragAndDrop.dragStartObject=B.dhtmlDragAndDrop.dragStartObject;
		window.dhtmlDragAndDrop.dragNode=B.dhtmlDragAndDrop.dragNode;
		window.dhtmlDragAndDrop.gldragNode=B.dhtmlDragAndDrop.dragNode;
		window.document.body.onmouseup=window.dhtmlDragAndDrop.stopDrag;
		window.waitDrag=0;
		if(((!_isIE)&&(C))&&((!_isFF)||(_FFrv<1.8))){
			window.dhtmlDragAndDrop.calculateFramePosition()
		}
	}
	if((parent.dhtmlDragAndDrop)&&(parent!=window)&&(parent!=B)){
		parent.dhtmlDragAndDrop.initFrameRoute(window)
	}
	for(var A=0;A<window.frames.length;A++){
		if((window.frames[A]!=B)&&(window.frames[A].dhtmlDragAndDrop)){
			window.frames[A].dhtmlDragAndDrop.initFrameRoute(window,((!B||C)?1:0))
		}
	}
};

var _isFF=false;
var _isIE=false;
var _isOpera=false;
var _isKHTML=false;
var _isMacOS=false;

if(navigator.userAgent.indexOf("Macintosh")!=-1){
	_isMacOS=true
}

if((navigator.userAgent.indexOf("Safari")!=-1)||(navigator.userAgent.indexOf("Konqueror")!=-1)){
	var _KHTMLrv=parseFloat(navigator.userAgent.substr(navigator.userAgent.indexOf("Safari")+7,5));
	if(_KHTMLrv>525){
		_isFF=true;
		var _FFrv=1.9
	}else{
		_isKHTML=true
	}
}else{
	if(navigator.userAgent.indexOf("Opera")!=-1){
		_isOpera=true;
		_OperaRv=parseFloat(navigator.userAgent.substr(navigator.userAgent.indexOf("Opera")+6,3))
	}else{
		if(navigator.appName.indexOf("Microsoft")!=-1){
			_isIE=true;
			if(navigator.appVersion.indexOf("MSIE 8.0")!=-1&&document.compatMode!="BackCompat"){
				_isIE=8
			}
		}else{
			_isFF=true;
			var _FFrv=parseFloat(navigator.userAgent.split("rv:")[1])
		}
	}
}

dtmlXMLLoaderObject.prototype.doXPath=function(C,E,D,I){
	if((_isKHTML)){
		return this.doXPathOpera(C,E)
	}
	if(_isIE){
		if(!E){
			if(!this.xmlDoc.nodeName){
				E=this.xmlDoc.responseXML
			}else{
				E=this.xmlDoc
			}
		}
		if(!E){
			dhtmlxError.throwError("LoadXML","Incorrect XML",[(E||this.xmlDoc),this.mainObject])
		}
		if(D!=null){
			E.setProperty("SelectionNamespaces","xmlns:xsl='"+D+"'")
		}
		if(I=="single"){
			return E.selectSingleNode(C)
		}else{
			return E.selectNodes(C)||new Array(0)
		}
	}else{
	var A=E;
	if(!E){
		if(!this.xmlDoc.nodeName){
			E=this.xmlDoc.responseXML
		}else{
			E=this.xmlDoc
		}
	}
	if(!E){
		dhtmlxError.throwError("LoadXML","Incorrect XML",[(E||this.xmlDoc),this.mainObject])
	}
	if(E.nodeName.indexOf("document")!=-1){
		A=E
	}else{
		A=E;
		E=E.ownerDocument
	}
	var G=XPathResult.ANY_TYPE;
	if(I=="single"){
		G=XPathResult.FIRST_ORDERED_NODE_TYPE
	}
	var F=new Array();
	var B=E.evaluate(C,A,function(J){return D},G,null);
	if(G==XPathResult.FIRST_ORDERED_NODE_TYPE){
		return B.singleNodeValue
	}
	var H=B.iterateNext();
	while(H){
		F[F.length]=H;
		H=B.iterateNext()
	}
	return F
	}
};

function _dhtmlxError(B,A,C){
	if(!this.catches){
		this.catches=new Array()
	}
	return this
}

_dhtmlxError.prototype.catchError=function(B,A){
	this.catches[B]=A};
	
_dhtmlxError.prototype.throwError=function(B,A,C){
		if(this.catches[B]){
			return this.catches[B](B,A,C)
		}
		if(this.catches.ALL){
			return this.catches.ALL(B,A,C)
		}
		alert("Error type: "+arguments[0]+"\nDescription: "+arguments[1]);
		return null
};

window.dhtmlxError=new _dhtmlxError();

dtmlXMLLoaderObject.prototype.doXPathOpera=function(C,A){
	var E=C.replace(/[\/]+/gi,"/").split("/");
	var D=null;
	var B=1;
	if(!E.length){
		return[]
	}
	if(E[0]=="."){
		D=[A]
	}else{
		if(E[0]==""){
			D=(this.xmlDoc.responseXML||this.xmlDoc).getElementsByTagName(E[B].replace(/\[[^\]]*\]/g,""));
			B++
		}else{
			return[]
		}
	}
	for(B;B<E.length;B++){
		D=this._getAllNamedChilds(D,E[B])
	}
	if(E[B-1].indexOf("[")!=-1){
		D=this._filterXPath(D,E[B-1])
	}
	return D
};

dtmlXMLLoaderObject.prototype._filterXPath=function(B,A){
	var D=new Array();
	var A=A.replace(/[^\[]*\[\@/g,"").replace(/[\[\]\@]*/g,"");
	for(var C=0;C<B.length;C++){
		if(B[C].getAttribute(A)){
			D[D.length]=B[C]
		}
	}
	return D
};

dtmlXMLLoaderObject.prototype._getAllNamedChilds=function(B,A){
	var E=new Array();
	if(_isKHTML){
		A=A.toUpperCase()
	}
	for(var D=0;D<B.length;D++){
		for(var C=0;C<B[D].childNodes.length;C++){
			if(_isKHTML){
				if(B[D].childNodes[C].tagName&&B[D].childNodes[C].tagName.toUpperCase()==A){
					E[E.length]=B[D].childNodes[C]
				}
			}else{
				if(B[D].childNodes[C].tagName==A){
					E[E.length]=B[D].childNodes[C]
				}
			}
		}
	}
	return E
};

function dhtmlXHeir(B,A){
	for(var C in A){
		if(typeof (A[C])=="function"){
			B[C]=A[C]
		}
	}
	return B
}

function dhtmlxEvent(B,C,A){
	if(B.addEventListener){
		B.addEventListener(C,A,false)
	}else{
		if(B.attachEvent){
			B.attachEvent("on"+C,A)
		}
	}
}

dtmlXMLLoaderObject.prototype.xslDoc=null;

dtmlXMLLoaderObject.prototype.setXSLParamValue=function(B,C,D){
	if(!D){
		D=this.xslDoc
	}
	if(D.responseXML){
		D=D.responseXML
	}
	var A=this.doXPath("/xsl:stylesheet/xsl:variable[@name='"+B+"']",D,"http://www.w3.org/1999/XSL/Transform","single");
	if(A!=null){
		A.firstChild.nodeValue=C
	}
};

dtmlXMLLoaderObject.prototype.doXSLTransToObject=function(D,B){
	if(!D){
		D=this.xslDoc
	}
	if(D.responseXML){
		D=D.responseXML
	}
	if(!B){
		B=this.xmlDoc
	}
	if(B.responseXML){
		B=B.responseXML
	}
	if(!_isIE){
		if(!this.XSLProcessor){
			this.XSLProcessor=new XSLTProcessor();
			this.XSLProcessor.importStylesheet(D)
		}
		var A=this.XSLProcessor.transformToDocument(B)
	}else{
		var A=new ActiveXObject("Msxml2.DOMDocument.3.0");
		try{
			B.transformNodeToObject(D,A)
		}catch(C){
			A=B.transformNode(D)
		}
	}
	return A
};

dtmlXMLLoaderObject.prototype.doXSLTransToString=function(C,B){
	var A=this.doXSLTransToObject(C,B);
	if(typeof (A)=="string"){
		return A
	}
	return this.doSerialization(A)
};

dtmlXMLLoaderObject.prototype.doSerialization=function(B){
	if(!B){
		B=this.xmlDoc
	}
	if(B.responseXML){
		B=B.responseXML
	}
	if(!_isIE){
		var A=new XMLSerializer();
		return A.serializeToString(B)
	}else{
		return B.xml
	}
};

dhtmlxEventable=function(obj){
	obj.dhx_SeverCatcherPath="";
	obj.attachEvent=function(name,catcher,callObj){
		name="ev_"+name.toLowerCase();
		if(!this[name]){
			this[name]=new this.eventCatcher(callObj||this)
		}
		return(name+":"+this[name].addEvent(catcher))
	};
	
	obj.callEvent=function(name,arg0){
		name="ev_"+name.toLowerCase();
			if(this[name]){
				return this[name].apply(this,arg0)
			}
		return true
	};
	
	obj.checkEvent=function(name){
		return(!!this["ev_"+name.toLowerCase()])
	};
	
	obj.eventCatcher=function(obj){
		var dhx_catch=[];
		var z=function(){
			var res=true;
			for(var i=0;i<dhx_catch.length;i++){
				if(dhx_catch[i]!=null){
					var zr=dhx_catch[i].apply(obj,arguments);
					res=res&&zr
				}
			}
			return res
		};
		z.addEvent=function(ev){
			if(typeof (ev)!="function"){
				ev=eval(ev)
			}
			if(ev){
				return dhx_catch.push(ev)-1
			}
			return false
		};
		z.removeEvent=function(id){
			dhx_catch[id]=null
		};
		return z
	};
	
	obj.detachEvent=function(id){
		if(id!=false){
			var list=id.split(":");
			this[list[0]].removeEvent(list[1])
		}
	}
};

function dataProcessor(A){
	this.serverProcessor=A;
	this.action_param="!nativeeditor_status";
	this.obj=null;this.updatedRows=[];
	this.autoUpdate=true;this.updateMode="cell";
	this._tMode="GET";
	this._waitMode=0;
	this._in_progress={};
	this._invalid={};
	this.mandatoryFields=[];
	this.messages=[];
	this.styles={updated:"font-weight:bold;",inserted:"font-weight:bold;",deleted:"text-decoration : line-through;",invalid:"background-color:FFE0E0;",invalid_cell:"border-bottom:2px solid red;",error:"color:red;",clear:"font-weight:normal;text-decoration:none;"};
	this.enableUTFencoding(true);
	dhtmlxEventable(this);
	return this
}

dataProcessor.prototype={setTransactionMode:function(B,A){
	this._tMode=B;
	this._tSend=A},escape:function(A){
		if(this._utf){
			return encodeURIComponent(A)
		}else{
			return escape(A)
		}
	},enableUTFencoding:function(A){
		this._utf=convertStringToBoolean(A)
	},setDataColumns:function(A){
		this._columns=(typeof A=="string")?A.split(","):A
	},getSyncState:function(){
		return !this.updatedRows.length
	},enableDataNames:function(A){
		this._endnm=convertStringToBoolean(A)
	},enablePartialDataSend:function(A){
		this._changed=convertStringToBoolean(A)
	},setUpdateMode:function(B,A){
		this.autoUpdate=(B=="cell");
		this.updateMode=B;
		this.dnd=A
	},setUpdated:function(D,C,E){
		var B=this.findRow(D);
		E=E||"updated";
		var A=this.obj.getUserData(D,this.action_param);
		if(A&&E=="updated"){
			E=A
		}if(C){
			this.set_invalid(D,false);
			this.updatedRows[B]=D;
			this.obj.setUserData(D,this.action_param,E)
		}else{
			if(!this.is_invalid(D)){
				this.updatedRows.splice(B,1);
				this.obj.setUserData(D,this.action_param,"")
			}
		}if(!C){
			this._clearUpdateFlag(D)
		}
		this.markRow(D,C,E);
		if(C&&this.autoUpdate){
			this.sendData(D)
		}
	},_clearUpdateFlag:function(){
		if(this.obj.mytype!="tree"){
			var B=this.obj.getRowById(rowId);
			if(B){
				for(var A=0;A<this.obj._cCount;A++){
					this.obj.cells(rowId,A).cell.wasChanged=false
				}
			}
		}
	},markRow:function(F,C,E){
		var D="";
		var B=this.is_invalid(F);
		if(B){
			D=this.styles[B];
			C=true
		}
		if(this.callEvent("onRowMark",[F,C,E,B])){
			if(C){
				D+=this.styles[E]
			}else{
				D+=this.styles.clear
			}
			this.obj[this._methods[0]](F,D);
			if(B&&B.details){
				D+=this.styles[B+"_cell"];
				for(var A=0;A<B.details.length;A++){
					if(B.details[A]){
						this.obj[this._methods[1]](F,A,D)
					}
				}
			}
		}
	},getState:function(A){
		return this.obj.getUserData(A,this.action_param)
	},is_invalid:function(A){
		return this._invalid[A]
	},set_invalid:function(C,B,A){
		if(A){
			B={
				value:B,details:A,toString:function(){
					return this.value.toString()
				}
			}
		}
		this._invalid[C]=B
	},checkBeforeUpdate:function(E){
		var D=true;
		var A=[];
		for(var C=0;C<this.obj._cCount;C++){
			if(this.mandatoryFields[C]){
				var B=this.mandatoryFields[C](this.obj.cells(E,C).getValue(),E,C);
				if(typeof B=="string"){
					this.messages.push(B)
				}else{
					D&=B;A[C]=!B
				}
			}
		}
		if(!D){
			this.set_invalid(E,"invalid",A);
			this.setUpdated(E,false)
		}
		return D
	},sendData:function(A){
		if(this._waitMode&&(this.obj.mytype=="tree"||this.obj._h2)){
			return 
		}
		if(this.obj.editStop){
			this.obj.editStop()
		}
		if(this.obj.linked_form){
			this.obj.linked_form.update()
		}
		if(typeof A=="undefined"||this._tSend){
			return this.sendAllData()
		}
		if(this._in_progress[A]){
			return false
		}
		this.messages=[];
		if(!this.checkBeforeUpdate(A)&&this.callEvent("onValidatationError",[A,this.messages])){
			return false
		}
		this._beforeSendData(this._getRowData(A),A)
	},_beforeSendData:function(A,B){
		if(!this.callEvent("onBeforeUpdate",[B,this.getState(B)])){
			return false
		}
		this._sendData(A,B)
	},_sendData:function(B,C){
		if(!B){
			return 
		}
		if(C){
			this._in_progress[C]=(new Date()).valueOf()
		}
		if(!this.callEvent("onBeforeDataSending",C?[C,this.getState(C)]:[])){
			return false
		}
		var A=new dtmlXMLLoaderObject(this.afterUpdate,this,true);
		var D=this.serverProcessor;
		if(this._tMode!="POST"){
			A.loadXML(D+((D.indexOf("?")!=-1)?"&":"?")+B)
		}else{
			A.loadXML(D,true,B)
		}
		this._waitMode++
	},sendAllData:function(){
		if(!this.updatedRows.length){
			return 
		}
		this.messages=[];
		var B=true;
		for(var A=0;A<this.updatedRows.length;A++){
			B&=this.checkBeforeUpdate(this.updatedRows[A])
		}
		if(!B&&!this.callEvent("onValidatationError",["",this.messages])){
			return false
		}
		if(this._tSend){
			this._sendData(this._getAllData())
		}else{
			for(var A=0;A<this.updatedRows.length;A++){
				if(!this._in_progress[this.updatedRows[A]]){
					if(this.is_invalid(this.updatedRows[A])){
						continue
					}
					this._beforeSendData(this._getRowData(this.updatedRows[A]),this.updatedRows[A]);
					if(this._waitMode&&(this.obj.mytype=="tree"||this.obj._h2)){
						return 
					}
				}
			}
		}
	},_getAllData:function(D){
		var B=new Array();
		var A=new Array();
		for(var C=0;C<this.updatedRows.length;C++){
			var E=this.updatedRows[C];
			if(this._in_progress[E]||this.is_invalid(E)){
				continue
			}
			if(!this.callEvent("onBeforeUpdate",[E,this.getState(E)])){
				continue
			}
			B[B.length]=this._getRowData(E,E+"_");
			A[A.length]=E;
			this._in_progress[E]=(new Date()).valueOf()
		}
		if(B.length){
			B[B.length]="ids="+A.join(",")
		}
		return B.join("&")
	},_getRowData:function(B,K){
		K=(K||"");
		if(this.obj.mytype=="tree"){
			var I=this.obj._globalIdStorageFind(B);
			var D=I.parentObject;
			var F=0;
			for(F=0;F<D.childsCount;F++){
				if(D.childNodes[F]==I){
					break}
			}
			var J=K+"tr_id="+this.escape(I.id);
			J+="&"+K+"tr_pid="+this.escape(D.id);
			J+="&"+K+"tr_order="+F;
			J+="&"+K+"tr_text="+this.escape(I.span.innerHTML);
			D=(I._userdatalist||"").split(",");
			for(F=0;F<D.length;F++){
				J+="&"+K+this.escape(D[F])+"="+this.escape(I.userData["t_"+D[F]])
			}
		}else{
			var J=K+"gr_id="+this.escape(B);
			if(this.obj.isTreeGrid()){
				J+="&"+K+"gr_pid="+this.escape(this.obj.getParentId(B))
			}
			var A=this.obj.getRowById(B);
			for(var F=0;F<this.obj._cCount;F++){
				if(this.obj._c_order){
					var G=this.obj._c_order[F]
				}else{
					var G=F
				}
				var H=this.obj.cells(A.idd,F);
				if(this._changed&&!H.wasChanged()){
					continue
				}
				if(this._endnm){
					J+="&"+K+this.obj.getColumnId(F)+"="+this.escape(H.getValue())
				}else{
					J+="&"+K+"c"+G+"="+this.escape(H.getValue())
				}
			}
			var E=this.obj.UserData[B];
			if(E){
				for(var C=0;C<E.keys.length;C++){
					J+="&"+K+E.keys[C]+"="+this.escape(E.values[C])
				}
			}
			var E=this.obj.UserData.gridglobaluserdata;
			if(E){
				for(var C=0;C<E.keys.length;C++){
					J+="&"+K+E.keys[C]+"="+this.escape(E.values[C])
				}
			}
		}
		if(this.obj.linked_form){
			J+=this.obj.linked_form.get_serialized(B,K)
		}
		return J
	},setVerificator:function(B,A){
		this.mandatoryFields[B]=A||(function(C){
			return(C!="")
		})
	},clearVerificator:function(A){
		this.mandatoryFields[A]=false
	},findRow:function(B){
		var A=0;
		for(A=0;A<this.updatedRows.length;A++){
			if(B==this.updatedRows[A]){
				break
			}
		}
		return A
	},defineAction:function(A,B){
		if(!this._uActions){
			this._uActions=[]
		}
		this._uActions[A]=B
	},afterUpdateCallback:function(A,F,E,D){
		delete this._in_progress[A];
		var C=(E!="error"&&E!="invalid");
		if(!C){
			this.set_invalid(A,E)
		}
		if((this._uActions)&&(this._uActions[E])&&(!this._uActions[E](D))){
			return 
		}
		this.setUpdated(A,false);
		var B=A;
		switch(E){
		case"inserted":
		case"insert":
			if(F!=A){
				this.obj[this._methods[2]](A,F);
				A=F
			}
			break;
		case"delete":
		case"deleted":
			this.obj.setUserData(A,this.action_param,"true_deleted");
			this.obj[this._methods[3]](A);
			return this.callEvent("onAfterUpdate",[A,E,F,D]);
			break
		}
		if(C){
			this.obj.setUserData(A,this.action_param,"")
		}
		this.callEvent("onAfterUpdate",[A,E,F,D])
	},afterUpdate:function(G,K,I,H,F){
		F.getXMLTopNode("data");
		if(!F.xmlDoc.responseXML){
			return 
		}
		var J=F.doXPath("//data/action");
		for(var D=0;D<J.length;D++){
			var E=J[D];
			var C=E.getAttribute("type");
			var A=E.getAttribute("sid");
			var B=E.getAttribute("tid");
			G.afterUpdateCallback(A,B,C,E)
		}
		if(G._waitMode){
			G._waitMode--
		}
		if((G.obj.mytype=="tree"||G.obj._h2)&&G.updatedRows.length){
			G.sendData()
		}
		G.callEvent("onAfterUpdateFinish",[]);
		if(!G.updatedRows.length){
			G.callEvent("onFullSync",[])
		}
	},init:function(B){
		this.obj=B;
		if(this.obj._dp_init){
			return this.obj._dp_init(this)
		}
		var A=this;
		if(this.obj.mytype=="tree"){
			this._methods=["setItemStyle","","changeItemId","deleteItem"];
			this.obj.attachEvent("onEdit",function(C,D){
				if(C==3){
					A.setUpdated(D,true)
				}
				return true
			}
			);this.obj.attachEvent("onDrop",function(G,F,E,D,C){
				if(D==C){
					A.setUpdated(G,true)
				}
			}
			);this.obj._onrdlh=function(C){
				if(A.getState(C)=="true_deleted"){
					return true
				}
				A.setUpdated(C,true,"deleted");
				return false
			};this.obj._onradh=function(C){
				A.setUpdated(C,true,"inserted")
			}
		}else{
			this._methods=["setRowTextStyle","setCellTextStyle","changeRowId",,"deleteRow"];
			this.obj.attachEvent("onEditCell",function(E,F,D){
				if(A._columns&&!A._columns[D]){
					return true
				}
				var C=A.obj.cells(F,D);
				if(E==1){
					if(C.isCheckbox()){
						A.setUpdated(F,true)
					}
				}else{
					if(E==2){
						if(C.wasChanged()){
							A.setUpdated(F,true)
						}
					}
				}
				return true
			}
			);this.obj.attachEvent("onRowPaste",function(C){
				A.setUpdated(C,true)
			}
			);this.obj.attachEvent("onRowIdChange",function(E,C){
				var D=A.findRow(E);
				if(D<A.updatedRows.length){
					A.updatedRows[D]=C
				}
			}
			);this.obj.attachEvent("onSelectStateChanged",function(C){
				if(A.updateMode=="row"){
					A.sendData()
				}
					return true
			}
			);this.obj.attachEvent("onEnter",function(D,C){
				if(A.updateMode=="row"){
					A.sendData()
				}
				return true
			}
			);this.obj.attachEvent("onBeforeRowDeleted",function(C){
				if(this.dragContext&&A.dnd){
					window.setTimeout(function(){
						A.setUpdated(C,true)
					},1);
					return true
				}
				var D=A.getState(C);
				if(this._h2){
					this._h2.forEachChild(C,function(E){
						A.setUpdated(E.id,false);
						A.markRow(E.id,true,"deleted")
					},this)
				}
				if(D=="inserted"){
					A.setUpdated(C,false);
					return true
				}
				if(D=="deleted"){
					return false
				}
				if(D=="true_deleted"){
					return true
				}
				A.setUpdated(C,true,"deleted");
				return false
			}
			);this.obj.attachEvent("onRowAdded",function(C){
				if(this.dragContext&&A.dnd){
					return true
				}
				A.setUpdated(C,true,"inserted");
				return true
			}
			);this.obj.on_form_update=function(C){
				A.setUpdated(C,true);
				return true
			}
		}
	},link_form:function(A){
		A.on_update=this.obj.on_form_update
	},setOnAfterUpdate:function(A){
		this.attachEvent("onAfterUpdate",A)
	},enableDebug:function(A){
	},setOnBeforeUpdateHandler:function(A){
		this.attachEvent("onBeforeDataSending",A)
	}
};

if(window.dhtmlXGridObject){
	dhtmlXGridObject.prototype._init_point_connector=dhtmlXGridObject.prototype._init_point;
	dhtmlXGridObject.prototype._init_point=function(){
		var A=function(E){
			E=E.replace(/(\?|\&)connector[^\f]*/g,"");
			return E+(E.indexOf("?")!=-1?"&":"?")+"connector=true"
		};
		var D=function(E){
			return A(E)+(this._connector_sorting||"")+(this._connector_filter||"")
		};
		var C=function(F,G,E){
			this._connector_sorting="&sort_ind="+G+"&sort_dir="+E;
			return D.call(this,F)
		};
		var B=function(F,E,H){
			this._connector_filter="&filter="+this._cCount+"&";
			for(var G=0;G<E.length;G++){
				E[G]="col"+E[G]+"="+encodeURIComponent(H[G])
			}
			this._connector_filter+=E.join("&");
			return D.call(this,F)
		};
		this.attachEvent("onCollectValues",function(E){
			if(this._server_lists&&this._server_lists[E]){
				return this._server_lists[E]
			}
			return true
		}
		);this.attachEvent("onBeforeSorting",function(H,G,F){
			if(G=="connector"){
				var E=this;
				this.clearAndLoad(C.call(this,this.xmlFileUrl,H,F),function(){
					E.setSortImgState(true,H,F)
				}
				);
				return false
			}
			return true
		}
		);this.attachEvent("onFilterStart",function(F,E){
			if(this._connector_filter_used){
				this.clearAndLoad(B.call(this,this.xmlFileUrl,F,E));
				return false
			}
			return true
		}
		);this.attachEvent("onXLE",function(N,M,K,J){
			if(!J){
				return 
			}
			var F=this.getUserData("","!linked_form");
			if(F&&(F=document.forms[F])&&!F.dhtmlx){
				this.linked_form=new dhtmlXForm(F.name,this.xmlFileUrl);
				this.attachEvent("onRowSelect",function(P){
					this.linked_form.load(P);
					return 
				}
				);
				if(this.on_form_update){
					this.linked_form.on_update=this.on_form_update
				}
			}
			if(!this._server_lists){
				var L=this.xmlLoader.doXPath("//options",J);
				if(L){
					this._server_lists=[]
				}
				for(var I=0;I<L.length;I++){
					var G=L[I].getAttribute("for");
					var E=this.xmlLoader.doXPath("./option",L[I]);
					var O=[];
					for(var H=0;H<E.length;H++){
						O[H]=E[H].firstChild?E[H].firstChild.data:""
					}
					this._server_lists[G]=O;
					this._loadSelectOptins(this.getFilterElement(G),G)
				}
			}
			if(this.refreshFilters){
				this._loadSelectOptins=function(){}
			}
		}
		);
		if(this._init_point_connector){
			this._init_point_connector()
		}
	};
	dhtmlXGridObject.prototype._in_header_connector_text_filter=function(B,A){
		this._connector_filter_used=true;
		return this._in_header_text_filter(B,A)
	};
	dhtmlXGridObject.prototype._in_header_connector_select_filter=function(B,A){
		this._connector_filter_used=true;
		return this._in_header_select_filter(B,A)
	}
}

if(window.dataProcessor){
	dataProcessor.prototype.init_original=dataProcessor.prototype.init;
	dataProcessor.prototype.init=function(A){
		this.init_original(A);
		A._dataprocessor=this;
		this.setTransactionMode("POST",true);
		this.serverProcessor+=(this.serverProcessor.indexOf("?")!=-1?"&":"?")+"editing=true"
	}
}

dhtmlxError.catchError("LoadXML",function(B,A,C){
	alert(C[0].responseText)
});

//Instancia de Scheduler
window.dhtmlXScheduler=window.scheduler={};

scheduler.init=function(C,A,B){
	A=A||(new Date());
	B=B||"week";
	this._obj=(typeof C=="string")?document.getElementById(C):C;
	this._els=[];
	this._scroll=true;
	this._quirks=(_isIE&&document.compatMode=="BackCompat");
	this._quirks7=(_isIE&&navigator.appVersion.indexOf("MSIE 8")==-1);
	dhtmlxEventable(this);
	this.init_templates();
	this.get_elements();
	this.set_actions();
	dhtmlxEvent(window,"resize",function(){
		window.clearTimeout(scheduler._resize_timer);
		scheduler._resize_timer=window.setTimeout(function(){
			scheduler.update_view()
		},100)
	}
	);
	this.set_sizes();
	this.setCurrentView(A,B)
};

scheduler.xy={nav_height:22,scale_left:50,scroll_width:18,scale_height:20};

scheduler.set_sizes=function(){
	var B=this._x=this._obj.clientWidth;
	var D=this._y=this._obj.clientHeight;
	var E=this._table_view?0:(this.xy.scale_left+this.xy.scroll_width);
	var A=this._table_view?-1:this.xy.scale_left;
	var C=this.xy.scale_height+this.xy.nav_height+(this._quirks?-2:0);
	this.set_xy(this._els.dhx_cal_navline[0],B,this.xy.nav_height,0,0);
	this.set_xy(this._els.dhx_cal_header[0],B-E,this.xy.scale_height,A,this.xy.nav_height+(this._quirks?-1:1));
	this.set_xy(this._els.dhx_cal_data[0],B,D-(C+2),0,C+2)
};

scheduler.set_xy=function(D,B,C,A,E){
	D.style.width=B+"px";
	D.style.height=C+"px";
	if(arguments.length>3){
		D.style.left=A+"px";D.style.top=E+"px"
	}
};

scheduler.get_elements=function(){
	var D=this._obj.getElementsByTagName("DIV");
	for(var C=0;C<D.length;C++){
		var A=D[C].className;
		if(!this._els[A]){
			this._els[A]=[]
		}
		this._els[A].push(D[C]);
		var B=scheduler.locale.labels[D[C].getAttribute("name")||A];
		if(B){
			D[C].innerHTML=B
		}
	}
};

//Acciones
scheduler.set_actions=function(){
	for(var A in this._els){
		if(this._click[A]){
			for(var B=0;B<this._els[A].length;B++){
				this._els[A][B].onclick=scheduler._click[A]
			}
		}
	}
	this._obj.onselectstart=function(C){
		return false
	};
	this._obj.onmousemove=function(C){
		scheduler._on_mouse_move(C||event)
	};
	this._obj.onmousedown=function(C){
		scheduler._on_mouse_down(C||event)
	};
	this._obj.onmouseup=function(C){
		scheduler._on_mouse_up(C||event)
	};
	/*this._obj.ondblclick=function(C){
		scheduler._on_dbl_click(C||event)
	}*/
};

scheduler.select=function(A){
	if(this._table_view){
		return 
	}
	if(this._select_id==A){
		return 
	}
	this.editStop(false);
	this.unselect();
	this._select_id=A;
	this.updateEvent(A)
};

scheduler.unselect=function(B){
	if(B&&B!=this._select_id){
		return 
	}
	var A=this._select_id;this._select_id=null;
	if(A){
		this.updateEvent(A)
	}
};

scheduler._click={
	dhx_cal_data:function(C){
		var B=C?C.target:event.srcElement;
		var E=scheduler._locate_event(B);
		if(E){
			scheduler.callEvent("onClick",[E,(C||event)]);
			scheduler.select(E);
			var A=B.className;
			if(A.indexOf("_icon")!=-1){
				scheduler._click.buttons[A.split(" ")[1].replace("icon_","")](E)
			}
		}else{
			if(new Date().valueOf()-(scheduler._new_event||0)>500&&scheduler._edit_id){
				var D=scheduler.locale.labels.confirm_closing;
				if(!D||confirm(D)){
					scheduler.editStop(scheduler.config.positive_closing)
				}
			}
		}
	},dhx_cal_prev_button:function(){
		scheduler.setCurrentView(scheduler.date.add(scheduler._date,-1,scheduler._mode))
	},dhx_cal_next_button:function(){
		scheduler.setCurrentView(scheduler.date.add(scheduler._date,1,scheduler._mode))
	},dhx_cal_today_button:function(){
		scheduler.setCurrentView(new Date())
	},dhx_cal_tab:function(){
		var A=this.getAttribute("name").split("_")[0];
		scheduler.setCurrentView(scheduler._date,A)
	},buttons:{"delete":function(B){
		var A=scheduler.locale.labels.confirm_deleting;
		if(!A||confirm(A)){
			scheduler.deleteEvent(B)
		}
		},edit:function(A){
			scheduler.edit(A)
		},save:function(A){
			scheduler.editStop(true)
		},details:function(A){
			scheduler.showLightbox(A)
		},cancel:function(A){
			scheduler.editStop(false)
		}
	}
};

scheduler._on_dbl_click=function(B){
	var C=B.target||B.srcElement;
	switch(C.className.split(" ")[0]){
		case"dhx_scale_holder":
		case"dhx_scale_holder_now":
		case"dhx_month_body":
			if(!scheduler.config.drag_create){
				break
			}
			var F=this._mouse_coords(B);
			var E=this._min_date.valueOf()+(F.y*this.config.time_step+(this._table_view?0:F.x)*24*60)*60000;
			var A=E+this.config.time_step*60000;
			this._drag_id=this.uid();
			this._drag_mode="new-size";
			this._loading=true;
			this.addEvent(new Date(E),new Date(A),this.locale.labels.new_event,this._drag_id);
			this._loading=false;
			this._on_mouse_up(B);
			break;
		case"dhx_body":
			var D=this._locate_event(C);
			if(this.config.details_on_dblclick){
				this.showLightbox(D)
			}else{
				this.edit(D)
			}
			break;
		case"dhx_cal_event_line":
		case"dhx_cal_event_clear":
			var D=this._locate_event(C);
			this.showLightbox(D);
			break
	}
};

scheduler._mouse_coords=function(A){
	var B;
	if(A.pageX||A.pageY){
		B={x:A.pageX,y:A.pageY}
	}else{
		B={x:A.clientX+document.body.scrollLeft-document.body.clientLeft,y:A.clientY+document.body.scrollTop-document.body.clientTop}
	}
	B.x-=getAbsoluteLeft(this._obj)+(this._table_view?0:this.xy.scale_left);
	B.y-=getAbsoluteTop(this._obj)+this.xy.nav_height+this.xy.scale_height-this._els.dhx_cal_data[0].scrollTop;
	if(!this._table_view){
		B.x=Math.max(0,Math.ceil(B.x/this._cols[0])-1);
		B.y=Math.max(0,Math.ceil(B.y*60/(this.config.time_step*this.config.hour_size_px))-1)+this.config.first_hour*(60/this.config.time_step)
	}else{
		B.y=(Math.max(0,Math.ceil(B.x/this._cols[0])-1)+Math.max(0,Math.ceil(B.y/this._colsS.height)-1)*7)*24*60/this.config.time_step;B.x=0
	}
	return B
};

scheduler._on_mouse_move=function(C){
	if(this._drag_mode){
		var E=this._mouse_coords(C);
		if(!this._drag_pos||this._drag_pos.x!=E.x||this._drag_pos.y!=E.y){
			this._drag_pos=E;
			if(this._drag_mode=="create"){
				this._loading=true;
				var D=this._min_date.valueOf()+(E.y*this.config.time_step+(this._table_view?0:E.x)*24*60)*60000;
				if(!this._drag_start){
					this._drag_start=D;
					return 
				}
				var A=D;
				if(A==this._drag_start){
					return 
				}
				this._drag_id=this.uid();
				this.addEvent(new Date(this._drag_start),new Date(A),this.locale.labels.new_event,this._drag_id);
				this._loading=false;
				this._drag_mode="new-size"
			}
			var B=this.getEvent(this._drag_id);
			var D,A;
			if(this._drag_mode=="move"){
				D=this._min_date.valueOf()+(E.y*this.config.time_step+E.x*24*60)*60000;
				A=B.end_date.valueOf()-(B.start_date.valueOf()-D)
			}else{
				D=B.start_date.valueOf();
				if(this._table_view){
					A=this._min_date.valueOf()+(E.y+(24*60/this.config.hour_size_px))*this.config.time_step*60000
				}else{
					A=this.date.date_part(B.end_date).valueOf()+E.y*this.config.time_step*60000
				}
				if(this._drag_mode=="new-size"){
					if(A<=this._drag_start){
						D=A;
						A=this._drag_start
					}
				}else{
					if(A<=D){
						A=D+this.config.time_step*60000
					}
				}
			}
			B.start_date=new Date(D);
			B.end_date=new Date(A);
			this.updateEvent(this._drag_id)
		}
	}
};

scheduler._on_mouse_down=function(A){
	var B=A.target||A.srcElement;
	switch(B.className.split(" ")[0]){
		case"dhx_cal_event_line":
			this._drag_mode="move";
			break;
		case"dhx_header":
		case"dhx_title":
			this._drag_mode="move";
			break;
		case"dhx_footer":
			this._drag_mode="resize";
			break;
		case"dhx_scale_holder":
		case"dhx_scale_holder_now":
		case"dhx_month_body":
			this._drag_mode="create";
			break;
		default:
			this._drag_mode=null;
			this._drag_id=null
		}
		if(this._drag_mode){
			if(!this.config["drag_"+this._drag_mode]){
				this._drag_mode=this._drag_id=0
			}else{
				this._drag_id=this._locate_event(B);
				this._drag_event=this._copy_event(this.getEvent(this._drag_id)||{})
			}
		}
		this._drag_start=null
};

scheduler._on_mouse_up=function(B){
	if(this._drag_mode&&this._drag_id){
		var A=this.getEvent(this._drag_id);
		if(!this._drag_event.start_date||A.start_date.valueOf()!=this._drag_event.start_date.valueOf()||A.end_date.valueOf()!=this._drag_event.end_date.valueOf()){
			var C=(this._drag_mode=="new-size");
			if(C&&this.config.edit_on_create){
				this.unselect();
				this._new_event=new Date();
				if(this._table_view||this.config.edit_on_create_details){
					this._drag_mode=null;
					return this.showLightbox(this._drag_id)
				}
				this._select_id=this._edit_id=this._drag_id
			}else{
				this.callEvent(C?"onEventAdded":"onEventChanged",[this._drag_id,this.getEvent(this._drag_id)])
			}this.render_view_data()
		}
	}
	this._drag_mode=null
};

//API
	
	scheduler.update_view=function(){
		this.set_sizes();
		this._reset_scale();
		if(this._load_mode&&!this._loaded[this._load_format(this._load_date(this._date))]){
			this._load()
		}else{
			this.render_view_data()
		}
	};
	
	scheduler.setCurrentView=function(A,D){
		this._mode=D||this._mode;
		this._date=A;
		this._table_view=(this._mode=="month");
		var C=this._els.dhx_cal_tab;
		for(var B=0;B<C.length;B++){
			C[B].className="dhx_cal_tab"+((C[B].getAttribute("name")==this._mode+"_tab")?" active":"")
		}
		this.update_view()
	};
	
	scheduler._reset_scale=function(){
		var E=(this._mode=="day"?1:7);
		var C=this._els.dhx_cal_header[0];
		var J=this._els.dhx_cal_data[0];
		C.innerHTML="";
		J.innerHTML="";
		this._cols=[];
		this.set_sizes();
		var K=parseInt(C.style.width);
		var A=0;
		var F,L,G,I;
		L=this.date[this._mode+"_start"](new Date(this._date.valueOf()));
		F=G=this._table_view?scheduler.date.week_start(L):L;I=this.date.date_part(new Date());
		var D=scheduler.date.add(L,1,this._mode);
		this._els.dhx_cal_date[0].innerHTML=this.templates[this._mode+"_date"](L,D,this._mode);
		this._min_date=F;
		for(var B=0;B<E;B++){
			this._cols[B]=Math.floor(K/(E-B));
			var H=document.createElement("DIV");
			H.className="dhx_scale_bar";
			this.set_xy(H,this._cols[B]-1,20,A,0);
			H.innerHTML=this.templates[this._mode+"_scale_date"](F,this._mode);
			C.appendChild(H);
			if(!this._table_view){
				var H=document.createElement("DIV");
				H.className="dhx_scale_holder";
				if(F.valueOf()==I.valueOf()){
					H.className="dhx_scale_holder_now"
				}else{
					H.className="dhx_scale_holder"
				}
				this.set_xy(H,this._cols[B]-1,this.config.hour_size_px*(this.config.last_hour-this.config.first_hour),A+51,0);
				J.appendChild(H)
			}
			F=this.date.add(F,1,"day");
			K-=this._cols[B];
			A+=this._cols[B]
		}
		this._max_date=F;
		if(this._table_view){
			this._reset_month_scale(J,L,G)
		}else{
			this._reset_hours_scale(J,L,G)
		}
	};
	
scheduler._reset_hours_scale=function(B,A,E){
	var G=document.createElement("DIV");
	G.className="dhx_scale_holder";
	var C=new Date(1980,1,1,this.config.first_hour,0,0);
	for(var D=this.config.first_hour;D<this.config.last_hour;D++){
		var F=document.createElement("DIV");
		F.className="dhx_scale_hour";
		F.style.height=this.config.hour_size_px-(this._quirks?0:1)+"px";
		F.innerHTML=scheduler.templates.hour_scale(C);G.appendChild(F);
		C=this.date.add(C,1,"hour")
	}
	B.appendChild(G)
};

scheduler._reset_month_scale=function(H,I,G){
	var F=scheduler.date.add(I,1,"month");
	var A=new Date();
	this.date.date_part(A);
	this.date.date_part(G);
	var K=Math.ceil((F.valueOf()-G.valueOf())/(60*60*24*1000*7));
	var B=[];
	var J=(Math.floor(H.clientHeight/K)-22);
	this._colsS={height:J+22};
	for(var D=0;D<=7;D++){
		B[D]=" style='height:"+J+"px; width:"+((this._cols[D]||0)-1)+"px;' ";this._colsS[D]=(this._cols[D-1]||0)+(this._colsS[D-1]||0)
	}
	this._min_date=G;var E="<table cellpadding='0' cellspacing='0'>";
	for(var D=0;D<K;D++){
		E+="<tr>";
		for(var C=0;C<7;C++){
			E+="<td";
			if(G<I){
				E+=" class='dhx_before' "
			}else{
				if(G>=F){
					E+=" class='dhx_after' "
				}else{
					if(G.valueOf()==A.valueOf()){
						E+=" class='dhx_now' "
					}
				}
			}
			E+="><div class='dhx_month_head'>"+this.templates.month_day(G)+"</div><div class='dhx_month_body' "+B[C]+"></div></td>";
			G=this.date.add(G,1,"day")
		}
		E+="</tr>"
	}
	E+="</table>";
	this._max_date=G;
	H.innerHTML=E
};

scheduler.date={
	date_part:function(A){
		A.setHours(0);
		A.setMinutes(0);
		A.setSeconds(0);
		A.setMilliseconds(0);
		return A
	},
	week_start:function(B){
		var A=B.getDay();
		if(scheduler.config.start_on_monday){
			if(A==0){
				A=6
			}else{
				A--
			}
		}
		return this.date_part(this.add(B,-1*A,"day"))
	},month_start:function(A){
		A.setDate(1);
		return this.date_part(A)
	},year_start:function(A){
		A.setMonth(0);
		return this.month_start(A)
	},day_start:function(A){
		return this.date_part(A)
	},add:function(B,C,D){
		var A=new Date(B.valueOf());
		switch(D){
		case"day":
			A.setDate(A.getDate()+C);
			break;
		case"week":
			A.setDate(A.getDate()+7*C);
			break;
		case"month":
			A.setMonth(A.getMonth()+C);
			break;
		case"year":
			A.setYear(A.getYear()+C);
			break;
		case"hour":
			A.setHours(A.getHours()+C);
			break;
		case"minute":
			A.setMinutes(A.getMinutes()+C);
			break
		}
		return A
	},to_fixed:function(A){
		if(A<10){
			return"0"+A
		}
		return A
	},copy:function(A){
		return new Date(A.valueOf())
	},date_to_str:function(B,A){
		B=B.replace(/%[a-zA-Z]/g,function(C){
			switch(C){
				case"%d":
					return'"+date.getDate()+"';
				case"%m":
					return'"+(date.getMonth()+1)+"';
				case"%y":
					return'"+date.getYear()+"';
				case"%Y":
					return'"+date.getFullYear()+"';
				case"%D":
					return'"+scheduler.locale.date.day_short[date.getDay()]+"';
				case"%l":
					return'"+scheduler.locale.date.day_full[date.getDay()]+"';
				case"%M":
					return'"+scheduler.locale.date.month_short[date.getMonth()]+"';
				case"%F":
					return'"+scheduler.locale.date.month_full[date.getMonth()]+"';
				case"%h":
					return'"+scheduler.date.to_fixed((date.getHours()%12))+"';
				case"%H":
					return'"+scheduler.date.to_fixed(date.getHours())+"';
				case"%i":
					return'"+scheduler.date.to_fixed(date.getMinutes())+"';
				case"%a":
					return'"+(date.getHours()>12?"am":"pm")+"';
				case"%A":
					return'"+(date.getHours()>12?"AM":"PM")+"';
				default:
					return C
			}
		}
		);
		if(A){
			B=B.replace(/date\.get/g,"date.getUTC")
		}
		return new Function("date",'return "'+B+'";')
	},str_to_date:function(E,C){
		var F="var temp=date.split(/[^0-9]+/g);";
		var A=E.match(/%[a-zA-Z]/g);
		for(var B=0;B<A.length;B++){
			switch(A[B]){
				case"%d":
					F+="set[2]=temp["+B+"]||0;";
					break;
				case"%m":
					F+="set[1]=(temp["+B+"]||1)-1;";
					break;
				case"%y":
					F+="set[0]=temp["+B+"]*1+(temp["+B+"]>50?1900:2000);";
					break;
				case"%h":
				case"%H":
					F+="set[3]=temp["+B+"]||0;";
					break;
				case"%i":
					F+="set[4]=temp["+B+"]||0;";
					break;
				case"%Y":
					F+="set[0]=temp["+B+"]||0;";
					break
			}
		}
		var D="set[0],set[1],set[2],set[3],set[4]";
		if(C){
			D=" Date.UTC("+D+")"
		}
		return new Function("date","var set=[0,0,0,0,0]; "+F+" return new Date("+D+");")
	}
};
//CAMBIOS EN LOS ICONOS AQUI
scheduler.locale={date:{month_full:["Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"], month_short:["Ene","Feb","Mar","Abr","May","Jun","Jul","Ago","Sep","Oct","Nov","Dic"], day_full:["Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"], day_short:["Dom","Lun","Mar","Mie","Jue","Vie","Sab"]},labels:{dhx_cal_today_button:"Hoy",day_tab:"Dia",week_tab:"Semana",month_tab:"Mes",new_event:"Nuevo Evento",icon_save:"Guardar",icon_cancel:"Aceptar",icon_details:"Detalles",icon_edit:"Editar",icon_delete:"Eliminar",confirm_closing:"",confirm_deleting:"El evento sera eliminado permamentemente, Esta seguro?",section_description:"Descripci&oacute;n de la Reserva",section_time:"Periodo de tiempo"}};

scheduler.config={default_date:"%d %M %Y",month_date:"%F %Y",week_date:"%l",day_date:"%D, %F %d",hour_date:"%H:%i",month_day:"%d",xml_date:"%m/%d/%Y %H:%i",api_date:"%d-%m-%Y %H:%i",hour_size_px:42,time_step:5,start_on_monday:1,first_hour:7,last_hour:21,drag_resize:1,drag_move:1,drag_create:1,edit_on_create:1,details_on_create:0,click_form_details:0,server_utc:false,positive_closing:false,icons_edit:["icon_save","icon_cancel"],icons_select:["icon_details"],lightbox:{sections:[{name:"description",height:200,map_to:"text",type:"textarea",focus:true},{name:"time",height:72,type:"time",map_to:"auto"}]}}	;

scheduler.init_templates=function(){
	var A=scheduler.date.date_to_str;
	var B=scheduler.config;
	scheduler.templates={day_date:A(B.default_date),month_date:A(B.month_date),week_date:function(D,C){return scheduler.templates.day_date(D)+" &ndash; "+scheduler.templates.day_date(C)},day_scale_date:A(B.default_date),month_scale_date:A(B.week_date),week_scale_date:A(B.day_date),hour_scale:A(B.hour_date),month_day:A(B.month_day),xml_date:scheduler.date.str_to_date(B.xml_date,B.server_utc),xml_format:A(B.xml_date,B.server_utc),api_date:scheduler.date.str_to_date(B.api_date),event_header:function(E,C,D){return scheduler.templates.hour_scale(E)+" - "+scheduler.templates.hour_scale(C)},event_text:function(E,C,D){return D.text},event_class:function(E,C,D){return""},event_bar_date:function(E,C,D){return scheduler.templates.hour_scale(E)+" "},event_bar_text:function(E,C,D){return D.text}}
};

scheduler.uid=function(){
	if(!this._seed){
		this._seed=(new Date).valueOf()
	}
	return this._seed++
};

scheduler._events={};

scheduler.clearAll=function(){
	this._events={};
	this.clear_view()
};
	
	scheduler.addEvent=function(A,G,D,F,B){
		var C=A;
		if(arguments.length!=1){
			C=B||{};
			C.start_date=A;
			C.end_date=G;
			C.text=D;
			C.id=F
		}
		C.id=C.id||scheduler.uid();
		C.text=C.text||"";
		C.extra_data=C.extra_data||{};
		if(typeof C.start_date=="string"){
			C.start_date=this.templates.api_date(C.start_date)
		}
		if(typeof C.end_date=="string"){
			C.end_date=this.templates.api_date(C.end_date)
		}
		C._timed=this.is_one_day_event(C);
		var E=!this._events[C.id];
		this._events[C.id]=C;
		this.event_updated(C);
		this.callEvent(E?"onEventAdded":"onEventChanged",[C.id,C])
	};
		
	scheduler.deleteEvent=function(C,A){
		var B=this._events[C];
		if(!A&&!this.callEvent("onBeforeEventDelete",[C,B])){
			return 
		}
		if(B){
			delete this._events[C];
			this.unselect(C);
			this.event_updated(B)
		}
	};
	
	scheduler.getEvent=function(A){
		return this._events[A]
	};
	
scheduler.setEvent=function(B,A){
		this._events[B]=A
};

scheduler.for_rendered=function(C,B){
	for(var A=this._rendered.length-1;A>=0;A--){
		if(this._rendered[A].getAttribute("event_id")==C){
			B(this._rendered[A],A)
		}
	}
};

scheduler.changeEventId=function(C,A){
	var B=this._events[C];
	if(B){
		B.id=A;
		this._events[A]=B;
		delete this._events[C]
	}
	this.for_rendered(C,function(D){
		D.setAttribute("event_id",A)
	});
	if(this._select_id==C){
		this._select_id=A
	}
	if(this._edit_id==C){
		this._edit_id=A
	}
};

(function(){
	var A=["Text","StartDate","EndDate"];
	var C=function(E){
		return function(F){
			return(scheduler.getEvent(F))[E]
		}
	};
	var D=function(E){
		return function(H,G){
			var F=scheduler.getEvent(H);F[E]=G;
			F._changed=true;
			scheduler.event_updated(F)
		}
	};
	for(var B=0;B<A.length;B++){
		scheduler["getEvent_"+A[B]]=C(A[B]);
		scheduler["setEvent"+A[B]]=D(A[B])
	}
})();

scheduler.event_updated=function(A){
	if(this.is_visible_events(A)){
		this.render_view_data()
	}
};

scheduler.is_visible_events=function(A){
	if(A.start_date<this._max_date&&this._min_date<A.end_date){
		return true
	}
	return false
};

scheduler.is_one_day_event=function(A){
	return(A.start_date.getDate()==A.end_date.getDate()&&A.start_date.getMonth()==A.end_date.getMonth()&&A.start_date.getFullYear()==A.end_date.getFullYear())
};

scheduler.get_visible_events=function(){
	var A=[];
	for(var B in this._events){
		if(this.is_visible_events(this._events[B])){
			if(this._table_view||this._events[B]._timed){
				A.push(this._events[B])
			}
		}
	}
	return A
};

scheduler.render_view_data=function(){
	if(this._not_render){
		this._render_wait=true;
		return 
	}
	this._render_wait=false;this.clear_view();
	var A=this.get_visible_events();
	this.render_data(A)
};

scheduler.render_data=function(A,C){
	A=this._pre_render_events(A,C);
	for(var B=0;B<A.length;B++){
		if(this._table_view){
			this.render_event_bar(A[B])
		}else{
			this.render_event(A[B])
		}
	}
};

scheduler._pre_render_events=function(A,B){
	if(!this._table_view){
		return this._pre_render_events_line(A,B)
	}else{
		return this._pre_render_events_table(A,B)
	}
};

scheduler._pre_render_events_line=function(B,E){
	B.sort(function(H,G){
		return H.start_date>G.start_date?1:-1
	}
	);
	var F=[[],[],[],[],[],[],[]];
	for(var C=0;C<B.length;C++){
		var D=B[C];
		D._sday=this.locate_holder_day(D.start_date);
		if(!E){
			var A=F[D._sday];
			while(A.length&&A[A.length-1].end_date<=D.start_date){
				A.splice(A.length-1,1)
			}
			if(A.length){
				A[A.length-1]._inner=true
			}
			D._sorder=A.length;
			A.push(D);
			if(A.length>(A.max_count||0)){
				A.max_count=A.length
			}
		}
	}
	if(!E){
		for(var C=0;C<B.length;C++){
			B[C]._count=F[B[C]._sday].max_count
		}
	}
	return B
};

scheduler._pre_render_events_table=function(I){
	I.sort(function(K,J){
		if(K.start_date.valueOf()==J.start_date.valueOf()){
			if(K._timed&&!J._timed){
				return 1
			}
			if(!K._timed&&J._timed){
				return -1
			}
			return 0
		}
		return K.start_date>J.start_date?1:-1
	}
	);
	var B=[];
	var A=[[],[],[],[],[],[],[]];
	var E;
	for(var C=0;C<I.length;C++){
		var H=I[C];
		var F=(E||H.start_date);
		var D=H.end_date;
		if(F<this._min_date){
			F=this._min_date
		}
		if(D>this._max_date){
			D=this._max_date
		}
		H._sday=this.locate_holder_day(F);
		H._eday=this.locate_holder_day(D)||7;
		H._sweek=Math.floor((F.valueOf()+3600000-this._min_date.valueOf())/(60*60*1000*24*7));
		var G=A[H._sweek];
		while(G.length&&G[G.length-1].end_date<=this.date.date_part(this.date.copy(H.start_date))){
			G.splice(G.length-1,1)
		}
		H._sorder=G.length;
		G.push(H);
		H._length=Math.ceil((D.valueOf()-F.valueOf())/(60*60*1000*24));
		if(H._sday+H._length<=7){
			E=null;
			B.push(H)
		}else{
			copy=this._copy_event(H);
			copy._length=7-H._sday;copy._eday=7;
			copy._sday=H._sday;copy._sweek=H._sweek;
			copy._sorder=H._sorder;
			copy.end_date=this.date.add(F,copy._length,"day");
			B.push(copy);
			E=copy.end_date;
			C--;
			continue
		}
	}
	return B
};

scheduler._copy_event=function(A){
	return{
		start_date:A.start_date,end_date:A.end_date,text:A.text,id:A.id
	}
};

scheduler._rendered=[];

scheduler.clear_view=function(){
	for(var A=0;A<this._rendered.length;A++){
		var B=this._rendered[A];
		if(B.parentNode){
			B.parentNode.removeChild(B)
		}
	}
	this._rendered=[]
};

scheduler.updateEvent=function(B){
	var A=this.getEvent(B);
	this.clear_event(B);
	if(A){
		this.render_data([A],true)
	}
};

scheduler.clear_event=function(A){
	this.for_rendered(A,function(C,B){
		if(C.parentNode){
			C.parentNode.removeChild(C)
		}
		scheduler._rendered.splice(B,1)
	})
};

scheduler.render_event=function(I){
	var J=scheduler.locate_holder(I._sday);
	var H=(Math.round((I.start_date.valueOf()-this._min_date.valueOf()-this.config.first_hour*60*60*1000)*this.config.hour_size_px/(60*60*1000)))%(this.config.hour_size_px*24)+1;
	var L=Math.max(25,Math.round((I.end_date.valueOf()-I.start_date.valueOf())*(this.config.hour_size_px+(this._quirks?1:0))/(60*60*1000))-14);
	var B=Math.ceil((J.clientWidth-25)/I._count);
	var C=I._sorder*B+1;
	if(!I._inner){
		B=B*(I._count-I._sorder)
	}
	var G=this._render_v_bar(I.id,25+C,H,B,L,I._text_style,scheduler.templates.event_header(I.start_date,I.end_date,I),scheduler.templates.event_text(I.start_date,I.end_date,I));
	this._rendered.push(G);
	J.appendChild(G);
	C=C+parseInt(J.style.left)+25;
	if(this._edit_id==I.id){
		B=Math.max(B-4,140);
		var G=document.createElement("DIV");
		G.setAttribute("event_id",I.id);
		this.set_xy(G,B,L-6,C,H+14);
		G.className="dhx_cal_editor";
		var A=document.createElement("DIV");
		this.set_xy(A,B-6,L-12);A.style.cssText+=";margin:2px 2px 2px 2px;";
		G.appendChild(A);
		this._els.dhx_cal_data[0].appendChild(G);
		this._rendered.push(G);
		A.innerHTML="<textarea class='dhx_cal_editor'>"+I.text+"</textarea>";
		if(this._quirks7){
			A.firstChild.style.height=L-16+"px"
		}
		this._editor=A.firstChild;
		this._editor.onkeypress=function(N){
			if((N||event).shiftKey){
				return true
			}
			var M=(N||event).keyCode;
			if(M==13){
				scheduler.editStop(true)
			}
			if(M==27){
				scheduler.editStop(false)
			}
		};
		A.firstChild.focus();
		A.firstChild.select()
	}
	if(this._select_id==I.id){
		var K=this.config["icons_"+((this._edit_id==I.id)?"edit":"select")];
		var F="";
		for(var E=0;E<K.length;E++){
			F+="<div class='dhx_menu_icon "+K[E]+"' title='"+this.locale.labels[K[E]]+"'></div>"
		}
		var D=this._render_v_bar(I.id,C-24,H,25,K.length*20+12,"","<div class='dhx_menu_head'></div>",F,true);
		D.style.left=C-(this._quirks7?24:24);
		this._els.dhx_cal_data[0].appendChild(D);
		this._rendered.push(D)
	}
};

scheduler._render_v_bar=function(D,M,L,N,H,B,F,E,A){
	var J=document.createElement("DIV");
	var K=this.getEvent(D);
	var I="dhx_cal_event";
	var C=scheduler.templates.event_class(K.start_date,K.end_date,K);
	if(C){
		I=I+" "+C
	}
	var G='<div event_id="'+D+'" class="'+I+'" style="position:absolute; top:'+L+"px; left:"+M+"px; width:"+(N-4)+"px; height:"+H+"px;"+(B||"")+'">';
	G+='<div class="dhx_header" style=" width:'+(N-6)+'px;" >&nbsp;</div>';
	G+='<div class="dhx_title">'+F+"</div>";
	G+='<div class="dhx_body" style=" width:'+(N-(this._quirks?4:14))+"px; height:"+(H-(this._quirks?6:16))+'px;">'+E+"</div>";G+='<div class="dhx_footer" style=" width:'+(N-8)+"px;"+(A?" margin-top:-1px;":"")+'" ></div></div>';
	J.innerHTML=G;return J.firstChild
};

scheduler.locate_holder=function(A){
	if(this._mode=="day"){
		return this._els.dhx_cal_data[0].firstChild
	}
	return this._els.dhx_cal_data[0].childNodes[A]
};

scheduler.locate_holder_day=function(B){
	var A=B.getDay()-this.config.start_on_monday;
	if(A<0){
		A+=7
	}
	return A
};

scheduler.render_event_bar=function(G){
	var I=this._els.dhx_cal_data[0];
	var H=this._colsS[G._sday];
	var A=this._colsS[G._eday];
	if(A==H){
		A=this._colsS[G._eday+1]
	}
	var F=this._colsS.height*G._sweek+22+G._sorder*20;
	var E=document.createElement("DIV");
	var D=G._timed?"dhx_cal_event_clear":"dhx_cal_event_line";
	var B=scheduler.templates.event_class(G.start_date,G.end_date,G);
	if(B){
		D=D+" "+B
	}
	var C='<div event_id="'+G.id+'" class="'+D+'" style="position:absolute; top:'+F+"px; left:"+H+"px; width:"+(A-H-15)+"px;"+(G._text_style||"")+'">';
	if(G._timed){
		C+=scheduler.templates.event_bar_date(G.start_date,G.end_date,G)
	}
	C+=scheduler.templates.event_bar_text(G.start_date,G.end_date,G)+"</div>";C+="</div>";
	E.innerHTML=C;
	this._rendered.push(E.firstChild);
	I.appendChild(E.firstChild)
};

scheduler._locate_event=function(A){
	var B=null;
	while(A&&!B&&A.getAttribute){
		B=A.getAttribute("event_id");
		A=A.parentNode
	}
	return B
};

scheduler.edit=function(A){
	if(this._edit_id==A){
		return 
	}
	this.editStop(false,A);
	this._edit_id=A;
	this.updateEvent(A)
};

scheduler.editStop=function(B,C){
	if(C&&this._edit_id!=C){
		return 
	}
	var A=this.getEvent(this._edit_id);
	if(A){
		if(B){
			A.text=this._editor.value
		}
		this._edit_id=null;
		this._editor=null;
		this.updateEvent(A.id);
		this._edit_stop_event(A,B)
	}
};

scheduler._edit_stop_event=function(A,B){
	if(this._new_event){
		if(!B){
			this.deleteEvent(A.id,true)
		}else{
			this.callEvent("onEventAdded",[A.id,A])
		}
		this._new_event=null
	}else{
		if(B){
			this.callEvent("onEventChanged",[A.id,A])
		}
	}
};

scheduler._loaded={};

scheduler._load_format=scheduler.date.date_to_str("%Y-%m-%d");

scheduler._load=function(A,C){
	A=A||this._load_url;A+=(A.indexOf("?")==-1?"?":"&")+"timeshift="+(new Date()).getTimezoneOffset();
	var B;
	C=C||this._date;
	if(this._load_mode){
		C=this._load_date(C);
		C=new Date(C.valueOf()-C.getTimezoneOffset()*60000);
		if(this._loaded[this._load_format(C)]){
			return true
		}
		B=this.date.add(C,1,this._load_mode);
		dhtmlxAjax.get(A+"&from="+this._load_format(C)+"&to="+this._load_format(B),function(D){scheduler.on_load(D)});
		this._loaded[this._load_format(C)]=true
	}else{
		dhtmlxAjax.get(A,function(D){scheduler.on_load(D)})
	}
};

scheduler._load_date=function(A){
	return this.date[this._load_mode+"_start"](new Date(A.valueOf()))
};

scheduler.on_load=function(A){
	this._loading=true;
	if(this._process){
		var B=this[this._process].parse(A.xmlDoc.responseText)
	}else{
		var B=this._magic_parser(A)
	}
	this._not_render=true;
	for(var C=0;C<B.length;C++){
		this.addEvent(B[C])
	}
	this._not_render=false;
	if(this._render_wait){
		this.render_view_data()
	}
	if(this._after_call){
		this._after_call()
	}
	this._after_call=null;
	this._loading=false
};

scheduler.load=function(A,B){
	if(typeof B=="string"){
		this._process=B;B=arguments[2]
	}
	this._load_url=A;
	this._after_call=B;
	this._load(A,this._date)
};

scheduler.setLoadMode=function(A){
	if(A=="all"){
		A=""
	}
	this._load_mode=A
};

scheduler.refresh=function(A){
	alert("No esta implementado")
};

scheduler._magic_parser=function(A){
	var C=A.getXMLTopNode("data");
	if(C.tagName!="data"){
		return[]
	}
	var B=[];
	var C=A.doXPath("//event");
	for(var D=0;D<C.length;D++){
		B[D]=this.xmlNodeToJSON(C[D]);
		B[D].text=B[D].text||B[D]._tagvalue;B[D].start_date=this.templates.xml_date(B[D].start_date);
		B[D].end_date=this.templates.xml_date(B[D].end_date)
	}
	return B
};

scheduler.xmlNodeToJSON=function(C){
	var B={};
	for(var A=0;A<C.attributes.length;A++){
		B[C.attributes[A].name]=C.attributes[A].value
	}
	for(var A=0;A<C.childNodes.length;A++){
		var D=C.childNodes[A];
		if(D.nodeType==1){
			B[D.tagName]=D.firstChild?D.firstChild.nodeValue:""
		}
	}
	if(!B.text){
		B.text=C.firstChild?C.firstChild.nodeValue:""
	}
	return B
};

//PARA EL DE LA DESCRIPCION
scheduler.form_blocks={textarea:{render:function(B){
	var A=(B.height||"130")+"px";
	return"<div class='dhx_cal_ltext' style='height:"+A+";'><textarea></textarea></div>"
	},
	set_value:function(B,C,A){
		B.firstChild.value=C||""
	},
	get_value:function(B,A){
		return B.firstChild.value
	},
	focus:function(B){
		var A=B.firstChild;A.select();
		A.focus()
	}},
	select:{render:function(D){
		var A=(D.height||"23")+"px";
		var C="<div class='dhx_cal_ltext' style='height:"+A+";'><select style='width:552px;'>";
		for(var B=0;B<D.options.length;B++){
			C+="<option value='"+D.options[B].key+"'>"+D.options[B].label+"</option>"
		}
		C+="</select></div>";
		return C
	},
	set_value:function(B,C,A){
		B.firstChild.value=C||""
	},
	get_value:function(B,A){
		return B.firstChild.value
	},
	focus:function(B){
		var A=B.firstChild;A.select();
		A.focus()
	}},
	time:{render:function(){
		var B;
		var C=this.date.date_part(new Date());
		var B="<select>";
		for(var A=0;A<60*24;A+=this.config.time_step){
			var D=this.templates.hour_scale(C);
			B+="<option value='"+A+"'>"+D+"</option>";
			C=this.date.add(C,this.config.time_step,"minute")
		}
		B+="</select> <select>";
		for(var A=1;A<32;A++){
			B+="<option value='"+A+"'>"+A+"</option>"
		}
		B+="</select> <select>";
		for(var A=0;A<12;A++){
			B+="<option value='"+A+"'>"+this.locale.date.month_full[A]+"</option>"
		}
		B+="</select> <select>";C=C.getFullYear()-5;
		for(var A=0;A<10;A++){
			B+="<option value='"+(C+A)+"'>"+(C+A)+"</option>"
		}
		B+="</select> ";
		//CAMBIO AQUI
		return"<div style='height:30px; padding-top:0px; font-size:inherit;' class='dhx_cal_lsection'>"+B+"<span style='font-weight:normal; font-size:10pt;'> &nbsp;&ndash;&nbsp; </span>"+B+"</div>"
		},
		set_value:function(C,D,B){
			function A(F,E,G){
				F[E+0].value=G.getHours()*60+G.getMinutes();
				F[E+1].value=G.getDate();
				F[E+2].value=G.getMonth();
				F[E+3].value=G.getFullYear()
			}
			s=C.getElementsByTagName("select");
			A(s,0,B.start_date);
			A(s,4,B.end_date)
		},
		get_value:function(B,A){
			s=B.getElementsByTagName("select");
			A.start_date=new Date(s[3].value,s[2].value,s[1].value,0,s[0].value);
			A.end_date=new Date(s[7].value,s[6].value,s[5].value,0,s[4].value)
		},
		focus:function(A){A.getElementsByTagName("select")[0].focus()}
	}
};

scheduler.showLightbox=function(B){
	if(!B){
		return 
	}
	this.show_cover();
	var A=this._get_lightbox();
	A.style.display="block";
	A.style.top=Math.round((document.body.offsetHeight-A.offsetHeight)/2)+"px";
	A.style.left=Math.round((document.body.offsetWidth-A.offsetWidth)/2)+"px";
	this._fill_lightbox(B,A)};
	scheduler._fill_lightbox=function(H,E){
		var D=this.getEvent(H);
		var B=E.getElementsByTagName("span");
		B[1].innerHTML=this.templates.event_header(D.start_date,D.end_date,D);
		B[2].innerHTML=this.templates.event_text(D.start_date,D.end_date,D);
		var F=this.config.lightbox.sections;
		for(var A=0;A<1;A++){
			var C=document.getElementById(F[A].id).nextSibling;
			var G=this.form_blocks[F[A].type];
			G.set_value.call(this,C,D[F[A].map_to],D);
			if(F[A].focus){
				G.focus.call(this,C)
			}
		}
		scheduler._lightbox_id=H
};
scheduler._empty_lightbox=function(){
	var H=scheduler._lightbox_id;
	var E=this.getEvent(H);
	var D=this._get_lightbox();
	var F=this.config.lightbox.sections;
	for(var B=0;B<F.length;B++){
		var C=document.getElementById(F[B].id).nextSibling;
		var G=this.form_blocks[F[B].type];
		var A=G.get_value.call(this,C,E);
		if(F[B].map_to!="auto"){
			E[F[B].map_to]=A
		}
	}
	E._timed=this.is_one_day_event(E);
	this.setEvent(E.id,E);
	this._edit_stop_event(E,true);
	this.render_view_data()
};

scheduler.hide_lightbox=function(A){
	this._get_lightbox().style.display="none";
	this.hide_cover();
	this._lightbox_id=null
};

scheduler.hide_cover=function(){
	if(this._cover){
		document.body.removeChild(this._cover)
	}
	this._cover=null
};

scheduler.show_cover=function(){
	this._cover=document.createElement("DIV");
	this._cover.className="dhx_cal_cover";
	document.body.appendChild(this._cover)
};

scheduler._init_lightbox_events=function(){
	this._get_lightbox().onclick=function(A){
		var B=A?A.target:event.srcElement;
		if(!B.className){
			B=B.previousSibling
		}
		if(B&&B.className){
			switch(B.className){
				/*case"dhx_save_btn":
					scheduler._empty_lightbox();
					scheduler.hide_lightbox();
					break;
				case"dhx_delete_btn":
					var C=scheduler.locale.labels.confirm_deleting;
					if(!C||confirm(C)){
						scheduler.deleteEvent(scheduler._lightbox_id);
						scheduler.hide_lightbox()
					}
					break;*/
				case"dhx_cancel_btn":
					scheduler._edit_stop_event(scheduler.getEvent(scheduler._lightbox_id),false);
					scheduler.hide_lightbox();
					break
				}
			}
		};
	this._get_lightbox().onkeypress=function(A){
		switch((A||event).keyCode){
			case 13:
				scheduler._empty_lightbox();
				scheduler.hide_lightbox();
				break;
			case 27:
				scheduler._edit_stop_event(scheduler.getEvent(scheduler._lightbox_id),false);
				scheduler.hide_lightbox();
				break
			}
		}
};

scheduler._get_lightbox=function(){
	if(!this._lightbox){
		var F=document.createElement("DIV");
		F.className="dhx_cal_light";
		F.style.visibility="hidden";
		F.innerHTML=this._lightbox_template;
		document.body.insertBefore(F,document.body.firstChild);
		this._lightbox=F;
		var D=this.config.lightbox.sections;
		var B="";
		//CAMBIO AQUI
		for(var A=0;A<1;A++){
			var E=this.form_blocks[D[A].type];
			if(!E){
				continue
			}
			D[A].id="area_"+this.uid();
			B+="<div id='"+D[A].id+"' class='dhx_cal_lsection'>"+this.locale.labels["section_"+D[A].name]+"</div>"+E.render.call(this,D[A])
		}
		var C=F.getElementsByTagName("div");
//CAMBIOS		//C[4].innerHTML=scheduler.locale.labels.icon_save;
		C[7].innerHTML=scheduler.locale.labels.icon_cancel;
//CAMBIOS		//C[10].innerHTML=scheduler.locale.labels.icon_delete;
		C[1].innerHTML=B;
		C[1].style.height=C[1].scrollHeight+"px";
		F.style.height=C[1].scrollHeight+50+"px";
        //F.style.height="20%";
		C[1].style.height=C[1].scrollHeight+"px";
		this._init_lightbox_events(this);
		F.style.display="none";
		F.style.visibility="visible"
	}
	return this._lightbox
};
//CAMBIOS
scheduler._lightbox_template="<div class='dhx_cal_ltitle'><span class='dhx_mark'>&nbsp;</span><span class='dhx_time'></span><span class='dhx_title'></span></div><div class='dhx_cal_larea'></div><div class='dhx_btn_set'><div class='dhx_save_btn'></div><div>&nbsp;</div></div><div class='dhx_btn_set'><div class='dhx_cancel_btn'></div><div>&nbsp;</div></div><div class='dhx_btn_set' style='float:right;'><div class='dhx_delete_btn'></div><div>&nbsp;</div></div>";

scheduler._dp_init=function(A){
	A._methods=["setEventTextStyle","","changeEventId","deleteEvent"];
	this.attachEvent("onEventAdded",function(B){
		if(!this._loading){
			A.setUpdated(B,true,"inserted")
		}
	});
	this.attachEvent("onBeforeEventDelete",function(C){
		var B=A.getState(C);
		if(B=="inserted"){
			A.setUpdated(C,false);
			return true
		}
		if(B=="deleted"){
			return false
		}
		if(B=="true_deleted"){
			return true
		}
		A.setUpdated(C,true,"deleted");
		return false	
	});
	this.attachEvent("onEventChanged",function(B){
		if(!this._loading){
			A.setUpdated(B,true,"updated")
		}
	});
	A._getRowData=function(F,B){
		B=B||"";
		var D=this.obj.getEvent(F);
		var E=[];
		for(var C in D){
			if(C.indexOf("_")==0){
				continue
			}
			if(C.indexOf("_date")!=-1){
				E.push(C+"="+this.obj.templates.xml_format(D[C]))
			}else{
				E.push(C+"="+this.escape(D[C]))
			}
		}
		return B+E.join("&"+B)};
		A._clearUpdateFlag=function(){}
	};

scheduler.setUserData=function(C,A,B){
	this.getEvent(C)[A]=B
};

scheduler.getUserData=function(B,A){
	return this.getEvent(B)[A]
};

scheduler.setEventTextStyle=function(B,A){
	this.for_rendered(B,function(C){C.style.cssText+=";"+A});
	this.getEvent(B)["_text_style"]=A
};