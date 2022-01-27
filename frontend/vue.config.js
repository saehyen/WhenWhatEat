module.exports = {
  transpileDependencies: [
    'vuetify'
  ],
  devServer: {
    proxy : 'http://52.79.230.195:8080/back',
    disableHostCheck: true
  }
}
