<template>
   <v-container style="margin : 5vh auto; max-width: 400px; width:100%;">
    
    <validation-observer
    ref="observer"
    v-slot="{ invalid }"
  >
    <form @submit.prevent="submit" 
          align="center">
      <validation-provider
        v-slot="{ errors }"
        name="ID"
        rules="required|max:10"
      >
        <v-text-field
          v-model="id"
          :counter="10"
          :error-messages="errors"
          label="ID"
          required
        ></v-text-field>
      </validation-provider>
      <validation-provider
        v-slot="{ errors }"
        name="password"
        rules="required|max:10"
        
      >
        <v-text-field
          v-model="password"
          :counter="11"
          :error-messages="errors"
          label="password"
          required
        ></v-text-field>
      </validation-provider>
      <validation-provider
        v-slot="{ errors }"
        name="name"
        rules="required|max:10"
      >
        <v-text-field
          v-model="name"
          :error-messages="errors"
          label="name"
          required
        ></v-text-field>
      </validation-provider>
      
      <validation-provider
        v-slot="{ errors }"
        rules="required"
        name="checkbox"
      >
        <v-checkbox
          v-model="checkbox"
          :error-messages="errors"
          value="1"
          label="개인정보동의"
          type="checkbox"
          required
        ></v-checkbox>
      </validation-provider>

      <v-btn
        class="mr-4"
        :disabled="invalid"
        @click="signup"
      >
        회원가입
      </v-btn>
      <v-btn @click="clear">
        초기화
      </v-btn>
    </form>
  </validation-observer>
  </v-container>
</template>

<script>
import axios from 'axios'
import { required, digits, email, max, regex } from 'vee-validate/dist/rules'
import { extend, ValidationObserver, ValidationProvider, setInteractionMode } from 'vee-validate'
setInteractionMode('eager')
extend('digits', {
  ...digits,
  message: '{_field_} needs to be {length} digits. ({_value_})',
})
extend('required', {
  ...required,
  message: '{_field_} can not be empty',
})
extend('max', {
  ...max,
  message: '{_field_} may not be greater than {length} characters',
})
extend('regex', {
  ...regex,
  message: '{_field_} {_value_} does not match {regex}',
})
export default {
  name: 'Signup',
  components: {
      ValidationProvider,
      ValidationObserver,
    },
    data: () => ({
      name: '',
      phoneNumber: '',
      email: '',
      select: null,
      checkbox: null,
      id:'',
      password:'',
      result:100,
    }),
    methods: {
      // 회원가입
      signup(){
        console.log("test")
        console.log(this.id + this.password + this.name)
        axios.post('http://52.79.230.195:8080/back/user/registUser?id='+this.id+'&password='+this.password+'&name='+this.name)
        .then(res =>{ 
          console.log(res.data)
          this.result = res.data;
          if (this.result == 0 ) {
            alert("아이디가 중복입니다.")
          }
          else if( this.result == 1) {alert("회원가입에 성공하셨습니다.")
          this.$router.push('/Login');
          // this.$router.go();}
          }
        })
        .catch(error => 
            console.log(error))
            
      },

      submit () {
        this.$refs.observer.validate()
      },

      clear () {
        this.name = ''
        this.id = ''
        this.password = null
        this.checkbox = null
        this.$refs.observer.reset()
      },
    },
  }
</script>

<style scoped>
.wrap {margin : 0 auto; max-width: 1400px; width:100%;}
</style>