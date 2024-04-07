@param de.tschuehly.svc.ui.layout.box.BoxComponent.BoxContext boxContext

<div style="border: red 2px solid; padding: 1rem;">
    @for(var viewContext: boxContext.viewContextList())
        ${viewContext}
    @endfor
</div>










