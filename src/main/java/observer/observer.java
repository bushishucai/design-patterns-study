/**
 * 观察者模式（Observer Pattern）是一种行为设计模式，
 * 它定义了一种一对多的依赖关系，让一个对象（主题或被观察者）的状态发生变化时，所有依赖于它的对象（观察者）都会得到通知并自动更新。
 * 这种模式通常用于处理对象之间的松耦合关系，其中一个对象的变化可以通知多个其他对象。
 *
 * 事件处理系统：事件处理是观察者模式的经典应用。例如，在GUI应用程序中，用户交互或系统事件（如按钮点击、鼠标移动、键盘输入等）可以触发事件，多个事件监听器作为观察者来订阅这些事件，并在事件发生时执行相应的操作。
 * 消息通知系统：当有新消息或通知需要发送给多个订阅者时，观察者模式可用于构建消息通知系统。发布者负责发布消息，而订阅者作为观察者接收并处理消息。
 * 发布-订阅模式：观察者模式也被称为发布-订阅模式。在发布-订阅系统中，发布者负责发布消息，而订阅者通过订阅感兴趣的主题或事件来接收消息。这种模式在消息队列、消息中间件和事件驱动架构中都有广泛的应用。
 * 监视文件或目录的变化：操作系统或文件系统可以充当被观察者，通知多个监视程序文件或目录的变化。
 * 股票市场报价系统：股票价格的变化可以通知多个投资者。股票市场系统可以将股票价格的变化作为事件，投资者作为观察者订阅这些事件，以及时做出决策。
 *
 * 观察者模式在以上场景中的共同特点是，一个被观察者对象（也称为主题或发布者）维护了一个观察者列表，
 * 观察者订阅主题，当主题的状态发生变化时，观察者会收到通知并执行相应的操作。
 * 这种模式使得被观察者和观察者之间的关系松耦合，增加了系统的灵活性和可扩展性。
 * 在实际应用中，观察者模式有助于构建响应式、事件驱动的系统，提高了系统的可维护性和可维护性。
 */