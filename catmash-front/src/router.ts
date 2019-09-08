import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import(/* webpackChunkName: "preHomePage" */ '@/views/Cats.vue'),
    },
    {
      path: '/vote',
      name: 'vote',
      component: () => import(/* webpackChunkName: "vote" */ '@/views/Vote.vue'),
    },
    {
      path: '/cats',
      name: 'cats',
      component: () => import(/* webpackChunkName: "catGrid" */ '@/views/Cats.vue'),
    },
  ],
});
