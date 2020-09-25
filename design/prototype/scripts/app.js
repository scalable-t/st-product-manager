const app = Vue.createApp({
  template: `<router-view></router-view>`
})

// imports
const { ref, computed } = Vue;
const { useRouter, useRoute } = VueRouter;

const NavBar = {
  template: `
  <div class="navbar">
    <div class="logo-container">
      <img src="images/logo.png" />
      <span>产品资源管理工具</span>
    </div>
    <ul class="nav">
      <li v-for="(nav, index) in navs"
        :key="nav.title"
        :class="{ nav: true, active: avtiveIndex === index }">
        <router-link :to="nav.link">{{ nav.title }}</router-link>
      </li>
    </ul>
  </div>
  `,
  setup() {
    const resp = {};
    function addResponse(obj) {
      Object.assign(resp, obj);
    }

    const route = useRoute();

    const navs = ref([
      { title: '资源管理', link: '/resources' },
      { title: '产品管理', link: '/product' },
      { title: '模块管理', link: '/module' },
      { title: '数据库管理', link: '/database' },
      { title: '接口管理', link: '/interface' },
      { title: '文档管理', link: '/document' },
    ]);
    addResponse({navs});

    const avtiveIndex = computed(() => {
      const path = route.path;
      for (var i = 0; i < navs.value.length; i++) {
        const value = navs.value[i];
        if (path.startsWith(value.link)) {
          return i;
        }
      }
      return 0;
    });
    addResponse({avtiveIndex});

    return resp;
  },
};

const Layout = {
  components: {
    NavBar
  },
  template: `
    <div class="st-layout">
      <NavBar />
      <div class="st-content">
        <router-view />
      </div>
    </div>`
};

const LoginComponent = {
  template: `<div class="login-page">
    <div class="navbar">
      <div class="logo-container">
        <img src="images/logo.png" />
        <span>产品资源管理工具</span>
      </div>
    </div>
    <div class="login-square">
      <div class="st-form">
        <div class="st-form-item">
          <label ><span>用户名</span><input v-model="username" class="st-input" type="text" maxlength="32"/></label>
        </div>
        <div class="st-form-item">
          <label ><span>密码</span><input v-model="password" class="st-input" type="password" maxlength="32"/></label>
        </div>
        <div class="st-form-item st-form-item-buttons">
          <button class="st-button" @click="handleLogin" :disabled="loggingIn">登录</button>
        </div>
      </div>
    </div>
  </div>`,
  setup() {
    const router = useRouter();

    const username = ref('');
    const password = ref('');
    const loggingIn = ref(false);
    const handleLogin = () => {
      loggingIn.value = true;
      services.login({username, password})
        .then(resp => {
          loggingIn.value = false;
          router.push('/resources');
        })
        .catch(() => loggingIn.value = false)
    };

    return {
      username,
      password,
      loggingIn,
      handleLogin,
    }
  },
};

const HomeComponent = {
  components: {
    NavBar
  },
  template: `
    <div class="homepage">
      asfasfsdf
    </div>`
};

const router = VueRouter.createRouter({
  history: VueRouter.createWebHashHistory(),
  routes: [
    { path: '', component: LoginComponent, alias: '/login' },
    { path: '/', component: Layout, children: [
      { path: '/resources', component: HomeComponent },
      { path: '/product', component: HomeComponent },
      { path: '/module', component: HomeComponent },
      { path: '/database', component: HomeComponent },
      { path: '/interface', component: HomeComponent },
      { path: '/document', component: HomeComponent },
    ] },
  ]
});
app.use(router);
