import datetime

import pytz
from django.http import HttpResponse
from django.shortcuts import render
from django.utils.translation import gettext as _, ngettext  # 1


def index(request):
    context_dict = {  # 2
        'localize_key': _('I am localized inside the view.')  # 3
    }
    return render(request, 'index.html', context_dict)  # 4


def add_cat(request, count):  # 1
    pluralized = ngettext(  # 2
        'added %(count)d cat',
        'added %(count)d cats', count
    ) % {'count': count}

    return HttpResponse(pluralized)  # 3


def get_current_date_time(request):
    date_time_now = datetime.datetime.now()  # 1
    date_time_dict = {  # 2
        'date_time_key': date_time_now,
    }

    return render(request, 'datetime.html', date_time_dict)  # 3


def bidi(request):
    return render(request, 'bidi.html')


def get_aware_current_date_time(request):
    dt_now_naive = datetime.datetime.now()  # 1
    localized_tz = pytz.timezone('Asia/Colombo')  # 2
    dt_now_aware = localized_tz.localize(dt_now_naive)  # 3

    return HttpResponse(dt_now_aware)  # 4


def switch_lang(request):
    return render(request, 'langswitch.html')
