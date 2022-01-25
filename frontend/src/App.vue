<template>
  <v-app>
    <v-app-bar
      app
      color="primary"
      dark
      shrink-on-scroll
      src="./assets/appbar.jpg"
      scroll-target="#scrolling-techniques-2"
    >
    
    <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>
    <v-spacer/>
    <router-link class="text-h5" style="text-decoration:none; margin : -40px 0" to="/">
            <img src="./assets/logo.png" width="200px" height="100%">
    </router-link>
    <v-spacer/>
       <v-btn  to="/Login">
        <v-icon
          size = "35">
          mdi-account-circle</v-icon>
        </v-btn>
        
    </v-app-bar>
    
  <v-navigation-drawer 
  v-model="drawer" 
  dark
  app
  :src="require('@/assets/menubackground.jpg')"
  >
  <template 
  v-slot:img="props"
  > 
    
    <v-img
      :gradient="gradient"
      v-bind="props">
    </v-img>
  </template>
      <v-list-item>
        <v-list-item-content>
            <router-link class="text-h5" style="text-decoration:none" to="/">
            <img src="./assets/logo.png" width="220px">
            </router-link>
        </v-list-item-content>
      </v-list-item>

      <v-divider></v-divider>

      <v-list
        dense
        nav
      >
        <v-list-item
          v-for="item in items"
          :key="item.title"
          link
          :to="item.to"
          active-class="primary"
          class="py-1"
        >
          <v-list-item-icon>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-main>
      <v-container fluid>
      <router-view/>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
export default {
  name: 'App',
  data: () => ({
    drawer:false,
    items: [
          { title: '홈', icon: 'mdi-home', to: '/' },
          { title: '내냉장고', icon: 'mdi-nutrition', to:'/Myrefrigerator'},
          { title: '랭킹', icon: 'mdi-chart-line', to:'/Ranking'},
          { title: '레시피', icon: 'mdi-food', to:'/Recipe' },
          { title: '관리자', icon: 'mdi-wrench', to:'/Admin' },
        ],
        right: null,
  }),
};
</script>
