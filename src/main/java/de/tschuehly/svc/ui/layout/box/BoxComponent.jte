@param de.tschuehly.svc.ui.layout.box.BoxComponent.BoxContext boxContext

<div style="border: red 2px solid; padding: 1rem;">
    @for(var content: boxContext.content().boxContents)
        ${boxContext.renderFunction().render(content)}
    @endfor
</div>