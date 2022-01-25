import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../views/Index.vue' 	
import axios from 'axios'
axios.defaults.xsrfCookieName = 'csrftoken'
axios.defaults.xsrfHeaderName = 'X-CSRFToken'

Vue.use(VueRouter); //vue 라우터 사용


const routes = [
	{
		path:'/'
		,name: 'Index'
		,component : Index
		, meta: {
			title: "언제뭐무꼬",
		  },
	},
	{
		path:'/Myrefrigerator'
		,name:'Myrefrigerator'
		, component: ()=> import('../views/Myrefrigerator.vue')
		, meta: {
			title: "내냉장고",
		  },
	},

	{
		path:'/Recipe'
		,name:'Recipe'
		, component: ()=> import('../views/Recipe.vue')
		, meta: {
			title: "레시피",
		  },
	},
	{
		path:'/Ranking'
		,name:'Ranking'
		, component: ()=> import('../views/Ranking.vue')
		, meta: {
			title: "랭킹",
		  },
	},
	{
		path:'/Admin'
		,name:'Admin'
		, component: ()=> import('../views/Admin.vue')
		, meta: {
			title: "관리자홈페이지",
		  },
	},
	{
		path:'/Ingredient/:id'
		,name:'Ingredient'
		, component: ()=> import('../views/Ingredient.vue')
		, meta: {
			title: "재료",
		  },
	},
	{
		path:'/Recipedetail/:id'
		,name:'Recipedetail'
		, component: ()=> import('../views/Recipedetail.vue')
		, meta: {
			title: "레시피상세",
		  },
	 },
  
	
	{
		path:'/Login'
		,name:'Login'
		, component: ()=> import('../views/Login.vue')
		, meta: {
			title: "로그인",
		  },
	},
	{
		path:'/Signup'
		,name:'Signup'
		, component: ()=> import('../views/Signup.vue')
		, meta: {
			title: "회원가입",
		  },
	},
	
	
]
  
const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})
router.afterEach((to,from) => {
	const title = to.meta.title === undefined ? '언제뭐무꼬' : to.meta.title;
	Vue.nextTick(() => {
		document.title = title;
	});
});
export default router