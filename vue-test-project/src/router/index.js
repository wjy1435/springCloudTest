import Vue from 'vue'
import VueRouter from 'vue-router'
// import Login from "../views/Login"
import Success from "../views/Success"
import Homepage from "../views/Homepage"
import Table from "../views/Table"
import WebSocket from "../views/WebSocketTest"
// import ChatRoom from "../views/ChatRoom"
Vue.use(VueRouter)

const routes = [
  // {
  //   path: '/',
  //   name: 'Login',
  //   component: Login
  // },

  {

      path: '/',
      name: 'WebSocket',
      component: WebSocket

  },
  // {
  //
  //     path: '/',
  //     name: 'ChatRoom',
  //     component: ChatRoom
  //
  // },
  {
    path: '/success',
    name: 'success',
    component: Success
  },
  {
    path: '/Table',
    name: 'Table',
    component: Table
  },
  {
    path: '/Homepage',
    name: 'Homepage',
    component: Homepage
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})



export default router
