# duitang-ui
仿堆糖UI的实现，此应用只简单的仿照堆糖APP的界面进行实现。  

###用到的第三方库  

**butterKnife**，解放空间对象实例化，解放监听添加的懒人库。源码*https://github.com/JakeWharton/butterknife/*  

**PagerSlidingTabStrip**，交互式页面指示器控件，完美配合ViewPager实现页面上方导航条效果。需注意ViewPager的适配器必须是继承FragmentPagerAdapter，并重写getPageIconResId(int position)或者getPageTitle(int position)方法，源码*https://github.com/astuetz/PagerSlidingTabStrip*  

**StaggeredGridView**，图片瀑布流库，源码*https://github.com/maurycyw/StaggeredGridView* 有图片加载功能，但功能相对简单。或*https://github.com/etsy/AndroidStaggeredGrid* 功能强大，可以自定义瀑布流列数。

**CircleImageView**，自定义圆形头像，源码*https://github.com/hdodenhof/CircleImageView*

**Picasso**，Square公司开源的一个Android图形缓存库，可实现图片下载和缓存功能。源码*https://github.com/square/picasso*


###遇到的问题  
*1. 第三方库的导入问题*  
第三方库的导入方法很多，最简单的是maven上面有的，可以直接在Project Structure中的dependencies导入。第二种是需要下载第三方jar包进行导入的，这个不同的第三方包的导入方法不同，可以在网上进行查询。  

*2. 滑动冲突问题的解决*
滑动冲突的解决可以为需要的控件设置onTouchListener，判断滑动的手势进行响应的操作，如setEnabled之类的。

###实现细节  
*1. 开屏图片及倒计时功能的实现*  
开屏图片采用picasso库进行加载，倒计时3s进入首页。此处有两种实现方式，一种是用handle，让线程休眠3s。第二种是用CountDownTimer在onFinish()方法中startActivity()  

*2. PagerSlidingTabStrip和ViewPager的配合使用*  
      // ViewPager的adapter，此处不同的position加载不同的fragment>  
      FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());  
      viewPager.setAdapter(adapter);// 为ViewPager设置adapter  
      indicator.setViewPager(viewPager);// 为PagerSlidingTabStrip设置viewPager  

*3. 自定义控件*  
在horizontalScrollView中放置一个自定义的LinearLayout控件，实现水平滑动展现

