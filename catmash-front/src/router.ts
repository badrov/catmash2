import Vue from 'vue';
import Router from 'vue-router';
import Home from './views/Home.vue';

Vue.use(Router);

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import(/* webpackChunkName: "preHomePage" */ '@/views/CatGrid.vue'),
    },
    {
      path: '/vote',
      name: 'vote',
      component: () => import(/* webpackChunkName: "vote" */ '@/views/Vote.vue'),
    },
    {
      path: '/catGrid',
      name: 'catGrid',
      component: () => import(/* webpackChunkName: "catGrid" */ '@/views/CatGrid.vue'),
    },
  ],
});
