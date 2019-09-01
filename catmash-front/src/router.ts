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
      name: 'catList',
      component: () => import(/* webpackChunkName: "catList" */ './views/CatList.vue'),
    },
    {
      path: '/vote',
      name: 'vote',
      component: () => import(/* webpackChunkName: "vote" */ './views/Vote.vue'),
    },
    {
      path: '/cat',
      name: 'cat',
      component: () => import(/* webpackChunkName: "cat" */ './views/Cat.vue'),
    },
    {
      path: '/catList',
      name: 'catList',
      component: () => import(/* webpackChunkName: "catList" */ './views/CatList.vue'),
    },
  ],
});
