# duitang-ui
仿堆糖UI的实现，此应用只简单的仿照堆糖APP的界面进行实现。  

###用到的第三方库  

butterKnife，解放空间对象实例化，解放监听添加的懒人库。源码*https://github.com/JakeWharton/butterknife/*  

PagerSlidingTabStrip，交互式页面指示器控件，完美配合ViewPager实现页面上方导航条效果。需注意ViewPager的适配器必须是继承FragmentPagerAdapter，并重写getPageIconResId(int position)或者getPageTitle(int position)方法，源码*https://github.com/astuetz/PagerSlidingTabStrip*  

StaggeredGridView，图片瀑布流库，源码*https://github.com/maurycyw/StaggeredGridView* 有图片加载功能，但功能相对简单。或*https://github.com/etsy/AndroidStaggeredGrid* 功能强大，可以自定义瀑布流列数。

CircleImageView，自定义圆形头像，源码*https://github.com/hdodenhof/CircleImageView*

Picasso，Square公司开源的一个Android图形缓存库，可实现图片下载和缓存功能。源码*https://github.com/square/picasso*


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
在horizontalScrollView中放置一个自定义的LinearLayout控件，实现水平滑动展现多张图片。在构造函数中进行多个View的设置(addView())

*4. Activity切换的动画效果*  
Activity在切换或者是退出的时候可以使用渐入，滑动，缩放等动态效果。  
使用的方法是在activity中直接调用overridePendingTransition(R.anim.zoomin, R.anim.zoomout)方法，第一个参数是起始动画，第二个参数是结束动画。通常在startActivity()或者是finish()后调用，在切换或是退出时就会调用此动画。  

*5. StaggeredGridView的图片加载前要先计算需要多大的空间放置图片*  
要重写onMeasure()方法，该方法传进去的不是一般的尺寸数值，而是尺寸和模式组合起来的数值。需要通过MeasureSpec.getMode()方法得到模式，再调用MeasureSpec.getSize()来得到尺寸。  
mode共有三种情况，UNSPECIFIED(未指定尺寸), EXACTLY(精确尺寸), AT_MOST(最大尺寸)。  
staggeredGridView的Item的尺寸计算的基本思路为：得到即将载入的控件的模式和尺寸，图片的尺寸，以及控件的内外边距，计算图片的高宽比，考虑控件指定的模式来计算图片放置进去的宽和高。再重新进行绘制。  

####仍然存在的问题  
1. 滑动冲突的问题没有完美解决，包括热门页面下拉刷新和gridView之间的冲突，以及状态页的冲突  
2. 热门页面的滑动存在问题，在使用scrollView包裹ViewPager和StaggeredGridView时会出现GridView无法显示的情况  
3. ViewPager的滑动指示点存在错误，滑动指示点的位置应该是固定不变的，而实现过程中将其与ViewPager一起变动
