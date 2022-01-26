import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import vuetify from './plugins/vuetify'
import VueYoutube from 'vue-youtube'
import VueSession from 'vue-session'
var sessionOptions ={
  persist: true
}
Vue.use(VueSession,sessionOptions)
Vue.use(VueYoutube)
Vue.config.productionTip = false
Vue.prototype.$axios = axios;
new Vue({
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')