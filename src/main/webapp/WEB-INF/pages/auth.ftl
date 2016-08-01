<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>vue-router</title>
		<script type="text/javascript" src="static/js/jquery-3.0.0.min.js"></script>
		<script type="text/javascript" src="static/js/vue.js"></script>
		<script type="text/javascript" src="static/js/vue-router.js"></script>
		<script type="text/javascript" src="static/js/myauth.js"></script>
		<style type="text/css">
			.header {
				position: fixed;
				top: 0px;
				width: 100%;
				height: 70px;
				background: red;
			}
			
			.content {
				margin-top: 70px;
				background: greenyellow;
				width: 100%;
				height: 566px;
				
			}
			
			.foot {

				width: 100%;
				background: blue;
				height: 50px;
			}
			.title{
				text-align: center;
			}
			.navibars{
				width: 17%;
				padding-left: 0px;
				height: 100%;
				background: black;
				float: left;
			}
			.pages{
				width: 83%;
				height: 100%;
				padding-right: 0px;
				background: white;
				float: right;
			}
		</style>
		
	</head>

	<body>
	<div class="header">
			<header>
				<h1 class="title">权限测试</h1>
			</header>	
	</div>
	<div id="app" class="content">
		<div class="navibars">	
			<ul>	
			   <#if auth?exists>
                <#list auth?keys as key> 
                  	<li><a v-link="{ path: '/${key}' }">${key}说：${auth[key]}</a></li>
                </#list>
            </#if>
		   </ul>
		</div>  	
			<!-- 路由外链 -->
		<div class="pages">	
				<router-view>
				</router-view>
		</div>
	</div>

		<script type="application/javascript">
			// 定义组件
			var php = Vue.extend({
				template: '<h1>php是世界上最好的语言</h1>'
				+'<div><button class="auth">save</button><button class="auth">edit</button><button class="auth">delete</button></div>'
			})

			var java = Vue.extend({
				template: '<h1>java是世界上最好的语言</h1>'
			})
			
			var python = Vue.extend({
				template: '<h1>python是世界上最好的语言</h1>'
			})
			
			var ruby = Vue.extend({
				template: '<h1>ruby是世界上最好的语言</h1>'
			})

			var golang = Vue.extend({
				template: '<h1>golang是世界上最好的语言</h1>'
			})
				
			var swift = Vue.extend({
				template: '<h1>swift是世界上最好的语言</h1>'
			})

			var scala = Vue.extend({
				template: '<h1>scala是世界上最好的语言</h1>'
			})
			// 路由器需要一个根组件。
			// 出于演示的目的，这里使用一个空的组件，直接使用 HTML 作为应用的模板
			var App = Vue.extend({})

			// 创建一个路由器实例
			// 创建实例时可以传入配置参数进行定制，为保持简单，这里使用默认配置
			var router = new VueRouter()

			// 定义路由规则
			// 每条路由规则应该映射到一个组件。这里的“组件”可以是一个使用 Vue.extend
			// 创建的组件构造函数，也可以是一个组件选项对象。
			// 稍后我们会讲解嵌套路由
			router.map({
				'/java': {
					component: java
				},
				'/php': {
					component: php
				},
				'/python': {
					component: python
				},
				'/swift': {
					component: swift
				},'/ruby': {
					component: ruby
				},
				'/golang': {
					component: golang
				}
			})

			// 现在我们可以启动应用了！
			// 路由器会创建一个 App 实例，并且挂载到选择符 #app 匹配的元素上。
			router.start(App, '#app');
			
			$(".auth").click(function(){
				console.log("xxx");
				var auth =${auth['php']};
				if(auth>>2>3){
					console.log("save 权限");
				}else{
					console.log("没有权限");
				}
						
			});
		</script>

	</body>
		
</html>