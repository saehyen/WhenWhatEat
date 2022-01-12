import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import vuetify from './plugins/vuetify'
import VueYoutube from 'vue-youtube'
Vue.use(VueYoutube)
Vue.config.productionTip = false
Vue.prototype.$axios = axios;
new Vue({
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')