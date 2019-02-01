from django.contrib import admin
from shop.models import Category, Product, Cart, CartItem, Order

admin.site.register(Category)
admin.site.register(Product)
admin.site.register(Cart)
admin.site.register(CartItem)
admin.site.register(Order)
