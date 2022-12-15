import Vue from 'vue'
import Router from 'vue-router'
import Profile from '../views/Profile.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import BrowseListings from '../views/BrowseListings.vue'
import Maintenance from '../views/Maintenance.vue'
import PropertyView from '../views/PropertyView.vue'
import RequestView from '../views/RequestView.vue'
import PropertyForm from '../views/PropertyForm.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/",
      name: "listings",
      component: BrowseListings,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/profile',
      name: 'profile',
      component: Profile,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/maintenance/:propID",
      name: "maintenance",
      component: Maintenance,
      meta: {
        requiresAuth: true
      }},
      {
      path: "/properties/:ID",
      name: "property-detail",
      component: PropertyView,
      meta: {
        requiresAuth: false
      }
    },
    {
    path: "/requests/:ID",
    name: "request-detail",
    component: RequestView,
    meta: {
      requiresAuth: false
    }
  }
    ,
    {
      path: "/new",
      name: "add-property",
      component: PropertyForm,
      meta: {
        requiresAuth: false
      }
    }
      ,
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
