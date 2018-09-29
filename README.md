# EsportFeeds
A simple app for reading live gaming news feeds based on a MVVM archiecture

dependencies:
1. CommonLib
  Make sure it is at the same directory as the App module 
  ie /home/user/EsportFeeds /home/user/CommonLib

2. Retrofit:
  industry standard networking library, easy to use, supports caching 

3. Retrofit SimpleXML converter
  part of retrofit for parsing/serialising xml data

4. Google Androd jetpack Architectural component

  Lifecycles, LiveData
  Observer pattern, Activity/Fragment(LifecycleOwner) observe LiveData Changes, change in data source(LiveData) can notify its   observers (UI activity/fragment). Library takes care of the complex android life cycle management, can focus on business       logic

  Databinding
  web style UI element binding in the layout xml file, source data changes can automatically update UI 

  ViewModel
  facilitate communication between UI and data repository layer, survives screen orientaiton change
  
5. TabLayout
  UI tabs library from google design, for displaying feed categories
  
6. RecylerView
  ListView replacement, 
  supports Vertical/Horizontal/Grid layout,
  comes with ViewHolder
  
  
