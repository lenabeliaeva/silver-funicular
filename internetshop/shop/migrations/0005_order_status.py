# Generated by Django 2.1.4 on 2019-01-13 12:29

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('shop', '0004_auto_20190111_1959'),
    ]

    operations = [
        migrations.AddField(
            model_name='order',
            name='status',
            field=models.CharField(choices=[('Принят в обработку', 'Принят в обработку'), ('Выполняется', 'Выполняется'), ('Оплачен', 'Оплачен')], default='Принят в обработку', max_length=100),
        ),
    ]