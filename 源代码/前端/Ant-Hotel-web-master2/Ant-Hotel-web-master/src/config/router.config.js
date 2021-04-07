// eslint-disable-next-line
import {
  UserLayout,
  BasicLayout,
  RouteView,
  BlankLayout,
  PageView
} from '@/layouts'
import {
  bxAnaalyse
} from '@/core/icons'

export const asyncRouterMap = [

  {
    path: '/',
    name: 'index',
    component: BasicLayout,
    meta: {
      title: '首页'
    },
    redirect: '/exception/attraction',
    children: [
      // dashboard

      // list

      // Exception
      {
        path: '/exception',
        name: 'exception',
        component: RouteView,
        redirect: '/exception/attraction',
        meta: { title: '地点推荐', icon: 'warning', permission: [ 'exception' ] },
        children: [
          {
            path: '/exception/attraction',
            name: '景点',
            component: () => import(/* webpackChunkName: "fail" */ '@/views/exception/attraction'),
            meta: { title: '景点', permission: [ 'exception' ] }
          },
          {
            path: '/exception/entertainment',
            name: '娱乐',
            component: () => import(/* webpackChunkName: "fail" */ '@/views/exception/entertainment'),
            meta: { title: '娱乐', permission: [ 'exception' ] }
          },
          {
            path: '/exception/hospital',
            name: '医院',
            component: () => import(/* webpackChunkName: "fail" */ '@/views/exception/hospital'),
            meta: { title: '医院', permission: [ 'exception' ] }
          },
          {
            path: '/exception/hotel',
            name: '旅馆',
            component: () => import(/* webpackChunkName: "fail" */ '@/views/exception/hotel'),
            meta: { title: '旅馆', permission: [ 'exception' ] }
          },
          {
            path: '/exception/restaurant',
            name: '餐厅',
            component: () => import(/* webpackChunkName: "fail" */ '@/views/exception/restaurant'),
            meta: { title: '餐厅', permission: [ 'exception' ] }
          },
          {
            path: '/exception/train',
            name: '路线',
            component: () => import(/* webpackChunkName: "fail" */ '@/views/exception/train'),
            meta: { title: '路线', permission: [ 'exception' ] }
          },

        ]
      },
      // other
    ]
  },
  {
    path: '*',
    redirect: '/404',
    hidden: true
  }
]

/**
 * 基础路由
 * @type { *[] }
 */
export const constantRouterMap = [{
    path: '/user',
    component: UserLayout,
    redirect: '/user/login',
    hidden: true,
    children: [{
        path: 'login',
        name: 'login',
        component: () => import( /* webpackChunkName: "user" */ '@/views/user/Login')
      },
      {
        path: 'register',
        name: 'register',
        component: () => import( /* webpackChunkName: "user" */ '@/views/user/Register')
      },
      {
        path: 'register-result',
        name: 'registerResult',
        component: () => import( /* webpackChunkName: "user" */ '@/views/user/RegisterResult')
      },
      {
        path: 'recover',
        name: 'recover',
        component: undefined
      }
    ]
  },

  {
    path: '/test',
    component: BlankLayout,
    redirect: '/test/home',
    children: [{
      path: 'home',
      name: 'TestHome',
      component: () => import('@/views/Home')
    }]
  },

  {
    path: '/404',
    component: () => import( /* webpackChunkName: "fail" */ '@/views/exception/404')
  }

]