<template>
<div>
	<header>
		<h1><router-link to="/"><img alt="Vue logo" src="../assets/logo.png">로고로고</router-link></h1>
		
		<button> 검색 </button>
		<input type="text" v-model="RecipeName" placeholder="검색할 음식 이름" />
		<div class="gnb_right">
			<div class="login"><router-link to="/Login">login</router-link></div>
			<div class="signup"><router-link to="/Signup">signup</router-link></div>
		</div>
	</header>
	<div class="menuWrap">
		<ul class="menu">
			<li><router-link to="/Myrefrigerator">나의냉장고</router-link></li>
			<li><router-link to="/Ranking">랭킹</router-link></li>
			<li><router-link to="/Recipe">레시피</router-link></li>
		</ul>
	</div>
</div>
</template>

<script>
export default {
	
}
</script>

<style scoped>
li {list-style: none;}
header{	max-width : 1400px; margin : 0 auto; width:100%;text-align:center;	position:relative;
	height:120px; display : flex; justify-content: center;}
a{text-decoration:none;	color:#333;}
header h1{margin:0}
header h1 img{height:40px;}
header input{height:35px;border:1px solid #818181; border-radius: 3px; width: 22vw; }
header button{height:40px; margin:0 0 0 50px; background : #EDE5D4; border:1px solid #333;}
header .gnb_right{display : flex; width:10vw; justify-content: space-evenly;}
header .login {border-radius: 50%; background-color : black; height: 30px; color: white; width:3vw; line-height: 25px;}
header .login a{color:white;}
header .signup{border-radius: 50%; background-color : black; height: 30px; color: white; width:3vw; line-height: 25px;}
header .signup a{color : white;}
.menuWrap .menu{display:flex; background-color:silver; width: 100%;
				max-width: 1400px; margin : 0 auto; padding:5px 0; justify-content: space-around;}
.menuWrap .menu li{margin : 0 20px; font-size:20px; font-weight: 600;}
</style>