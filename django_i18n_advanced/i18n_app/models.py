from django.db import models
from django.db.models import Model


class DateTimeModel(Model):
    date_time_field = models.DateTimeField()
