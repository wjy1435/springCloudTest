import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);
//这里要导入store
import store from "./store";


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
