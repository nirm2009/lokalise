"""django_i18n_advanced URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/3.1/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path, include
from i18n_app import views


urlpatterns = [
    path('admin/', admin.site.urls),
    path('', views.index),
    path('add/<int:count>/', views.add_cat),
    path('datetime/', views.get_current_date_time),
    path('bidi/', views.bidi),
    path('awaredatetime/', views.get_aware_current_date_time),
    path('i18n/', include('django.conf.urls.i18n')),
    path('langswitch/', views.switch_lang),
]
