package com.yg.a4thseminar.Fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.yg.a4thseminar.FirstFragment
import com.yg.a4thseminar.R
import com.yg.a4thseminar.SecondFragment
import com.yg.a4thseminar.ThirdFragment
import com.yg.a4thseminar.ViewPager.MainActivity
import kotlinx.android.synthetic.main.activity_main2.*


class Main2Activity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        main2_first_btn.setOnClickListener(this)
        main2_second_btn.setOnClickListener(this)
        main2_third_btn.setOnClickListener(this)
        main2_tag_btn.setOnClickListener(this)
        main2_to_main_btn.setOnClickListener(this)

        if (savedInstanceState == null) {                   //savedInstanceState 동일한 액티비티가 재실행 될 때 저장된 값이 있는지 판단!
            //물론 이 예제에서 다루지 않을것이지만 다룬다 하여도 최초실행시에는 저장된 것이 없겠죠??
            val bundle = Bundle()
            bundle.putString("title", main2_first_btn!!.text.toString())
            AddFragment(FirstFragment(), bundle, "first")
        }
    }


    override fun onClick(v: View?) {
        when(v){
            main2_first_btn -> {
                var bundle = Bundle()
                bundle.putString("title", main2_first_btn!!.text.toString())
                //AddFragment(FirstFragment(), bundle, "first", supportFragmentManager.findFragmentById(R.id.main2_container))
                ReplaceFragment(FirstFragment(), bundle, "first")
            }
            main2_second_btn -> {
                var bundle = Bundle()
                bundle.putString("title", main2_second_btn!!.text.toString())
//                AddFragment(SecondFragment(), bundle, "second", supportFragmentManager.findFragmentById(R.id.main2_container))
                ReplaceFragment(SecondFragment(), bundle, "second")
            }
            main2_third_btn -> {
                var bundle = Bundle()
                bundle.putString("title", main2_third_btn!!.text.toString())
//                AddFragment(ThirdFragment(), bundle, "third", supportFragmentManager.findFragmentById(R.id.main2_container))
                ReplaceFragment(ThirdFragment(), bundle, "third")
            }
            main2_tag_btn->{
                TagFragment(main2_tag_edit.text.toString())
            }
            main2_to_main_btn->{
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }

    fun AddFragment(fragment: Fragment, bundle: Bundle, tag: String, fragment2: Fragment) {
        val fm = supportFragmentManager               // 프레그먼트 매니져 객체를 생성
        val transaction = fm.beginTransaction()        // 트랜젝션 객체를 생성 프레그먼트 매니져 클래스를 통해 해당 트랙젝션을 수행하겠다는 의미
        transaction.remove(fragment2)                                  // 기존 프레그먼트 제거
        fragment.arguments = bundle                                 // bundle 객체를 넘겨준다
        transaction.add(R.id.main2_container, fragment, tag)         // 새로운 프레그먼트 추가!!
        //transaction.addToBackStack(null);                             // 백스텍에 저장!!
        transaction.commit()
    }

    fun AddFragment(fragment: Fragment, bundle: Bundle, tag: String) {            //오버라이딩하여 최초에 추가될 프레그먼트 생성함수
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        fragment.arguments = bundle
        transaction.add(R.id.main2_container, fragment, tag)
        //transaction.addToBackStack(null);
        transaction.commit()
    }

    fun TagFragment(tag: String) {
        Log.v("home", tag)
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        val fragment = supportFragmentManager.findFragmentByTag(tag)
        if(fragment!=null) {
            transaction.replace(R.id.main2_container, fragment)
            transaction.commit()
        }
    }

    fun ReplaceFragment(fragment: Fragment, bundle: Bundle, tag: String) {
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        fragment.arguments = bundle
        transaction.replace(R.id.main2_container, fragment, tag)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
