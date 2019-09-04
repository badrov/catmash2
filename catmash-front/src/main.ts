import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import vGallery from 'v-gallery';

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  vGallery,
  render: (h) => h(App),
}).$mount('#app');
