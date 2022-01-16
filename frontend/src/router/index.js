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
	},
	{
		path:'/Myrefrigerator'
		,name:'Myrefrigerator'
		, component: ()=> import('../views/Myrefrigerator.vue')
	},

	{
		path:'/Recipe'
		,name:'Recipe'
		, component: ()=> import('../views/Recipe.vue')
	},
	{
		path:'/Ranking'
		,name:'Ranking'
		, component: ()=> import('../views/Ranking.vue')
	},
	{
		path:'/Ingredient'
		,name:'Ingredient'
		, component: ()=> import('../views/Ingredient.vue')
	},
	{
		path:'/Recipedetail'
		,name:'Recipedetail'
		, component: ()=> import('../views/Recipedetail.vue')
	 },
  
	{
		path:'/Test'
		,name:'Test'
		, component: ()=> import('../views/Test.vue')
	},
	{
		path:'/Login'
		,name:'Login'
		, component: ()=> import('../views/Login.vue')
	},
	{
		path:'/Signup'
		,name:'Signup'
		, component: ()=> import('../views/Signup.vue')
	},
	
]
  
const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})
  
export default router