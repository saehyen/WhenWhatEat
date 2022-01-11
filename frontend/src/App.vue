<template>
  <v-app>
    <v-app-bar
      app
      color="primary"
      dark
    >
    <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>
    <v-spacer/>
    
    </v-app-bar>

  <v-navigation-drawer v-model="drawer" app>
      <v-list-item>
        <v-list-item-content>
          <v-list-item-title class="text-h6">
            로고로고
          </v-list-item-title>
          <v-list-item-subtitle>
            레시피
          </v-list-item-subtitle>
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
          { title: '홈', icon: 'mdi-view-dashboard', to: '/' },
          { title: '내냉장고', icon: 'mdi-image', to:'/Myrefrigerator'},
          { title: '랭킹', icon: 'mdi-help-box', to:'/Ranking'},
          { title: '레시피', icon: 'mdi-help-box', to:'/Recipe' },
        ],
        right: null,
  }),
};
</script>
