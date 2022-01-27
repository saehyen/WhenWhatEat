<template>
   <v-container style="margin : 5vh auto; max-width: 400px; width:100%;">
    <v-card-title class="primary--text" 
          align="center">
       <v-form>
    <v-container fluid>
      <v-row >
        <v-col
          cols="12"
        >
          <v-text-field
            v-model="userid"
            :append-icon="show2 ? 'mdi-eye' : 'mdi-eye-off'"
            :rules="[rules.required, rules.min]"
            :type="show2 ? 'text' : 'password'"
            name="input-10-2"
            label="아이디"
            hint=" 8글자 이상 입력하세요"
            value=""
            class="input-group--focused"
            @click:append="show2 = !show2"
          ></v-text-field>
        </v-col>

        <v-col
          cols="12"
        >
          <v-text-field
            v-model="password"
            :append-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'"
            :rules="[rules.required, rules.min]"
            :type="show1 ? 'text' : 'password'"
            name="input-10-1"
            label="비밀번호"
            hint="8글자 이상 입력하세요"
            counter
            @click:append="show1 = !show1"
          ></v-text-field>
          <v-btn
            color="black"
            text
            @click="join"
          > 로그인
          </v-btn>

          <v-btn
            color="black"
            text
            to="/Signup"
          >
            회원가입
          </v-btn>
        </v-col>
      </v-row>
    </v-container>
       </v-form>
     </v-card-title>
  </v-container>
</template>

<script>
import axios from 'axios'
export default {
  name: 'Login',
  data () {
      return {
        show1: false,
        show2: true,
        show3: false,
        show4: false,
        password: '',
        id:'',
        username: this.$session.get('username'),
        userid: this.$session.get('useruid'),
        prevlog : this.$session.get('islogin'),
        rules: {
          required: value => !!value || 'Required.',
          min: v => v.length >= 4 || 'Min 8 characters',
          emailMatch: () => (`The email and password you entered don't match`),
        },
      }
  },
  methods : {
      get_name(){
        console.log(this.id)
          axios.get('http://52.79.230.195:8080/back/user/userInfo?id='+this.id)
        .then(res =>{
          console.log(res.data.result[0])
          this.$session.set('username',res.data.result[0].name);
          this.$session.set('useruid',res.data.result[0].uid);
          this.$session.set('islogin', true);
          this.$session.set('userId', this.id);
          this.$router.push('/Myrefrigerator');
          // this.$router.go();
        })
        .catch(error => 
            console.log(error))
        },
     join(){
            const config={
                baseUrl:'http://52.79.230.195:8080/back'
             };
            var User ={
                'id' : this.userid,
                'password' : this.password
            }
            console.log(User);
            this.id = User.id
            axios.post(`${config.baseUrl}/user/login?id=`+User.id+'&password='+User.password)
            .then((response)=>{
                var flag = response.data;
                if(response.status === 200){
                    if(flag==0){
                      alert("로그인 성공");
                      this.get_name();
                        
                    }
                    else if(flag==1){
                        this.$router.go();
                        alert("아이디 혹은 비밀번호가 틀렸습니다.");
                        console.log("일치하는 아이디가 없음");
                    }else if(flag==2){
                        this.$router.go();
                        alert("아이디 혹은 비밀번호가 틀렸습니다.");
                        console.log("비밀번호가 일치하지 않음");
                    }else {
                        this.$router.push('/Login');
                    }
                }else{
                    alert(response)
                    alert("통신에러");
                }
            }).catch((err)=>{
                alert(err);
                console.log(err);
                alert("예외 에러");
            })
      },
      
  }
}
</script>

<style scoped>
.wrap {margin : 0 auto; max-width: 1400px; width:100%;}
</style>