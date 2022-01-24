module.exports = {
  transpileDependencies: [
    'vuetify'
  ],
  //outputDir: '/var/www/html/' ,
  devServer: {
    proxy : 'http://ec2-13-124-134-65.ap-northeast-2.compute.amazonaws.com:8080',
    disableHostCheck: true
  }
}
